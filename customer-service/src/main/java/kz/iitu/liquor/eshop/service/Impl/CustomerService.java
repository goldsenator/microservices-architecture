package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CustomerDTO;
import kz.app.cart.shopping.model.Customer;
import kz.app.cart.shopping.repository.CustomerRepository;
import kz.app.cart.shopping.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    //    @Value("${service.order.url}")
//    String orderApi;

    final String orderApi = "http://localhost:8086/order/";


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
      public Customer save(CustomerDTO customerDTO) {
         Customer customer;
         log.info("Start save method");

        if (customerDTO.getId() == null) {
            log.info("new customer");
            customer = Customer.builder()
                    .customerCode(customerDTO.getCustomerCode())
                    .customerName(customerDTO.getCustomerName())
                    .avatar(customerDTO.getAvatar())
                    .emailAddress(customerDTO.getEmailAddress())
                    .contactNumber(customerDTO.getContactNumber())
                    .completeAddress(customerDTO.getCompleteAddress())
                    .username(customerDTO.getUsername())
                    .password(customerDTO.getPassword())
                    .build();
        } else {
            log.info("not new customer");
            customer = getById(customerDTO.getId());

            customer.setCustomerCode(customerDTO.getCustomerCode());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setAvatar(customerDTO.getAvatar());
            customer.setContactNumber(customerDTO.getContactNumber());
            customer.setEmailAddress(customerDTO.getEmailAddress());
            customer.setCompleteAddress(customerDTO.getCompleteAddress());
            customer.setUsername(customerDTO.getUsername());
            customer.setPassword(customerDTO.getPassword());
        }

        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        log.info("savedCustomer = " + savedCustomer.getId());

        return savedCustomer;
    }

    public Customer getCustomerInformationByIdFallback(Long id){
        Customer customer = new Customer();
        customer.setName
    }
    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "getCustomerInformationByIdFallback",
            threadPoolKey = "getById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    public Customer getCustomerInformationByIdFallback(Long id){
        Customer customer = new Customer();
        customer.setId(0L);
        customer.setCustomerName("CustomerName is not available:Service Unavailable");
        customer.setCustomerCode("CustomerCode is not available:Service Unavailable");
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
