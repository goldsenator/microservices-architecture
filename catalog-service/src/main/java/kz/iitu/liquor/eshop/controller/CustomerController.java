package kz.iitu.liquor.eshop.controller;

import kz.iitu.liquor.eshop.dto.CatalogDTO;
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
    public ResponseEntity<?> save(@RequestBody CatalogDTO catalogDTO) {
        log.info("CatalogDTO : " + catalogDTO.toString());
        return ResponseEntity.ok(null);
    }


}
