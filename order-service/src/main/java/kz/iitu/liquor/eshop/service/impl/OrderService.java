package kz.iitu.liquor.eshop.service.impl;

import kz.iitu.liquor.eshop.dto.OrderDTO;
import kz.iitu.liquor.eshop.model.Cart;
import kz.iitu.liquor.eshop.model.Customer;
import kz.iitu.liquor.eshop.model.Order;
import kz.iitu.liquor.eshop.model.OrderDetail;
import kz.iitu.liquor.eshop.repository.OrderRepository;
import kz.iitu.liquor.eshop.service.IOrderDetailService;
import kz.iitu.liquor.eshop.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    protected final IOrderDetailService orderDetailService;

//    @Value("${service.customer.url}")
//    String customerApi;
    final String customerApi = "http://localhost:8087/customer/";

//    @Value("${service.cart.url}")
//    String cartApi;
    final String cartApi = "http://localhost:8083/cart/";

    private Object runGetMethod(String url, Object object) {
        log.info("get method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    object.getClass());
            log.info("responseEntity in GET METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in GET method : " + e.getLocalizedMessage());
            return null;
        }
    }

    private Object runPostMethod(String url, Object body, Object object) {
        log.info("post method url : " + url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(body, headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    object.getClass());
            log.info("responseEntity in POST METHOD = {} ", responseEntity.getBody());
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Exception in POST method : " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order;

        OrderDetail orderDetail = orderDetailService.update(orderDTO);
        Customer customer = (Customer) runGetMethod(customerApi + orderDTO.getCustomerId(), new Customer());


        if (orderDTO.getId() == null) {
            order = Order.builder()
                    .referenceNo(orderDTO.getReference_no())
                    .orderDate(new Date())
                    .expectedDeliveryDate(orderDTO.getExpectedDeliveryDate())
                    .numberOfItems(orderDTO.getNumberOfItems())
                    .totalAmount(orderDTO.getTotalAmount())
                    .orderDetail(orderDetail)
//                    .customer(customer)
                    .build();

        } else {
            order = getById(orderDTO.getId());

            order.setReferenceNo(orderDTO.getReference_no());
            order.setOrderDate(new Date());
            order.setExpectedDeliveryDate(orderDTO.getExpectedDeliveryDate());
            order.setNumberOfItems(orderDTO.getNumberOfItems());
            order.setOrderDetail(orderDetail);
//            order.setCustomer(customer);
            order.setTotalAmount(orderDTO.getTotalAmount());
        }

        Order savedOrder = orderRepository.saveAndFlush(order);

        log.info("order saved = " + savedOrder.getId());
        updateCart(savedOrder, orderDTO.getCartId());

        log.info("carts updated");

        return savedOrder;
    }

    private void updateCart (Order order, List<Long> cartIds) {
        log.info("updating cart");
        for (Long cartId : cartIds) {
            Cart updatedCart = (Cart) runPostMethod(cartApi + "update?cartId=" + cartId, order, new Cart());
            log.info("cart updated = " + cartId);
        }
    }
    @Override
    public boolean makeOrder(Long customerId, Long cartId) {

        return true;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
