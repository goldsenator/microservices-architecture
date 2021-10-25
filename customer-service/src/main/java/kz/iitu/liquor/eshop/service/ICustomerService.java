package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.CustomerDTO;
import kz.iitu.liquor.eshop.model.Customer;
import java.util.List;

    public interface ICustomerService {

        Customer save(CustomerDTO customerDTO);
        void deleteById(Long id);
        Customer getById(Long id);
        List<Customer> getAll();
    }


