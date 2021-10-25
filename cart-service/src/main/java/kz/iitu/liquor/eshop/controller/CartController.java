package kz.iitu.liquor.eshop.controller;

import com.google.gson.Gson;
import kz.iitu.liquor.eshop.dto.CartDTO;
import kz.iitu.liquor.eshop.model.Cart;
import kz.iitu.liquor.eshop.model.Order;
import kz.iitu.liquor.eshop.service.ICartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
public class CartController {

    private final ICartService cartService;

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.save(cartDTO));
    }

    @PostMapping("/update")
    public ResponseEntity<Cart> updateCart(@RequestBody Order order, @RequestParam Long cartId) {
        log.info("updating cart controller");
        log.info("cart = " + new Gson().toJson(order));
        log.info("cartId = " + cartId);
        return ResponseEntity.ok(cartService.updateCart(order, cartId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cartService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getAll() {
        return ResponseEntity.ok(cartService.getAll());
    }
}
