package kz.iitu.liquor.eshop.controller;

import kz.iitu.liquor.eshop.dto.CustomerDTO;
import kz.iitu.liquor.eshop.model.Customer;
import kz.iitu.liquor.eshop.service.ICustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO) {
        log.info("customerDTO : " + customerDTO.toString());
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO) {
        log.info("here");
        return ResponseEntity.ok(customerService.save(customerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

}
