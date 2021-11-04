package kz.app.cart.shopping.controller;

import kz.app.cart.shopping.dto.CartProductDTO;
import kz.app.cart.shopping.model.CartProduct;
import kz.app.cart.shopping.service.ICartProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/product")
public class CartProductController {
    
    private final ICartProductService cartProductService;

    @PostMapping
    public ResponseEntity<CartProduct> create(@RequestBody CartProductDTO cartProductDTO) {
        return ResponseEntity.ok(cartProductService.save(cartProductDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartProduct> getById(@PathVariable Long id){
        return ResponseEntity.ok(cartProductService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cartProductService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<CartProduct>> getAll() {
        return ResponseEntity.ok(cartProductService.getAll());
    }
    
}
