package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CartCategoryDTO;
import kz.app.cart.shopping.model.CartCategory;

import java.util.List;

public interface ICartCategoryService {

    CartCategory save(CartCategoryDTO cartCategoryDTO);
    void deleteById(Long id);
    CartCategory getById(Long id);

    List<CartCategory> getAll();
}
