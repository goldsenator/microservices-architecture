package kz.app.cart.shopping.contoller;

import kz.app.cart.shopping.dto.CatalogDTO;
import kz.app.cart.shopping.model.Customer;
import kz.app.cart.shopping.service.ICustomerService;
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
