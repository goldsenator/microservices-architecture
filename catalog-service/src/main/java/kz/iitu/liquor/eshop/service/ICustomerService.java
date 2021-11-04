package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CatalogDTO;
import kz.app.cart.shopping.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer save(CatalogDTO catalogDTO);
    void deleteById(Long id);
    Customer getById(Long id);

    List<Customer> getAll();
}
