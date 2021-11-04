package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CustomerDTO;
import kz.app.cart.shopping.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer save(CustomerDTO customerDTO);
    void deleteById(Long id);
    Customer getById(Long id);

    List<Customer> getAll();
}
