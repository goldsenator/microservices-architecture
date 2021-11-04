package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CartProductCategoryDTO;
import kz.app.cart.shopping.model.CartProductCategory;

import java.util.List;

public interface ICartProductCategoryService {

    CartProductCategory save(CartProductCategoryDTO cartProductCategoryDTO);
    void deleteById(Long id);
    CartProductCategory getById(Long id);

    List<CartProductCategory> getAll();
}
