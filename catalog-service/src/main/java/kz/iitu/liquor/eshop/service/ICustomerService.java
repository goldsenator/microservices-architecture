package kz.iitu.liquor.eshop.catalogservice.service;

import kz.iitu.liquor.eshop.dto.CatalogDTO;
import kz.iitu.liquor.eshop.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer save(CatalogDTO catalogDTO);
    void deleteById(Long id);
    Customer getById(Long id);

    List<Customer> getAll();
}
