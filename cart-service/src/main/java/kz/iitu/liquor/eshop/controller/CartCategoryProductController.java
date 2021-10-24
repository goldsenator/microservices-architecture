package kz.iitu.liquor.eshop.controller;

import kz.iitu.liquor.eshop.dto.CartProductCategoryDTO;
import kz.iitu.liquor.eshop.model.CartProductCategory;
import kz.iitu.liquor.eshop.service.ICartProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category/product")
public class CartCategoryProductController {

    private final ICartProductCategoryService cartProductCategoryService;
    
    @PostMapping
    public ResponseEntity<CartProductCategory> create(@RequestBody CartProductCategoryDTO cartProductCategoryDTO) {
        return ResponseEntity.ok(cartProductCategoryService.save(cartProductCategoryDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartProductCategory> getById(@PathVariable Long id){
        return ResponseEntity.ok(cartProductCategoryService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cartProductCategoryService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<CartProductCategory>> getAll() {
        return ResponseEntity.ok(cartProductCategoryService.getAll());
    }
}
