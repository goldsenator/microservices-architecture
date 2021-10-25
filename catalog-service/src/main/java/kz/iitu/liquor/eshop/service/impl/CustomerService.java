package kz.iitu.liquor.eshop.catalogservice.service.impl;

import kz.iitu.liquor.eshop.dto.CatalogDTO;
import kz.iitu.liquor.eshop.model.Customer;
import kz.iitu.liquor.eshop.repository.CustomerRepository;
import kz.iitu.liquor.eshop.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer save(CatalogDTO catalogDTO) {
        Customer customer;

        log.info("Start save method");

        if (catalogDTO.getId() == null) {
            log.info("new customer");
            customer = Customer.builder()
                    .customerCode(catalogDTO.getCustomerCode())
                    .customerName(catalogDTO.getCustomerName())
                    .avatar(catalogDTO.getAvatar())
                    .emailAddress(catalogDTO.getEmailAddress())
                    .contactNumber(catalogDTO.getContactNumber())
                    .completeAddress(catalogDTO.getCompleteAddress())
                    .username(catalogDTO.getUsername())
                    .password(catalogDTO.getPassword())
                    .build();
        } else {
            log.info("not new customer");
            customer = getById(catalogDTO.getId());

            customer.setCustomerCode(catalogDTO.getCustomerCode());
            customer.setCustomerName(catalogDTO.getCustomerName());
            customer.setAvatar(catalogDTO.getAvatar());
            customer.setContactNumber(catalogDTO.getContactNumber());
            customer.setEmailAddress(catalogDTO.getEmailAddress());
            customer.setCompleteAddress(catalogDTO.getCompleteAddress());
            customer.setUsername(catalogDTO.getUsername());
            customer.setPassword(catalogDTO.getPassword());
        }

        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        log.info("savedCustomer = " + savedCustomer.getId());

        return savedCustomer;
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
