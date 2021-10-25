package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.OrderDTO;
import kz.iitu.liquor.eshop.model.Order;

import java.util.List;

public interface IOrderService {

    Order save(OrderDTO orderDTO);
    boolean makeOrder(Long customerId, Long cartId);
    void deleteById(Long id);
    Order getById(Long id);

    List<Order> getAll();
}
