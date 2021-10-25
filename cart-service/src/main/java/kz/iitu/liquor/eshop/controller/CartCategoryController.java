package kz.iitu.liquor.eshop.controller;

import kz.iitu.liquor.eshop.dto.CartCategoryDTO;
import kz.iitu.liquor.eshop.model.CartCategory;
import kz.iitu.liquor.eshop.service.ICartCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category")
public class CartCategoryController {
    
    private final ICartCategoryService cartCategoryService;
    
    @PostMapping
    public ResponseEntity<CartCategory> create(@RequestBody CartCategoryDTO cartCategoryDTO) {
        return ResponseEntity.ok(cartCategoryService.save(cartCategoryDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartCategory> getById(@PathVariable Long id){
        return ResponseEntity.ok(cartCategoryService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        cartCategoryService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<CartCategory>> getAll() {
        return ResponseEntity.ok(cartCategoryService.getAll());
    }

}
