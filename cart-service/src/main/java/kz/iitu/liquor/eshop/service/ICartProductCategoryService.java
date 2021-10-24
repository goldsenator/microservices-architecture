package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.CartProductCategoryDTO;
import kz.iitu.liquor.eshop.model.CartProductCategory;

import java.util.List;

public interface ICartProductCategoryService {

    CartProductCategory save(CartProductCategoryDTO cartProductCategoryDTO);
    void deleteById(Long id);
    CartProductCategory getById(Long id);

    List<CartProductCategory> getAll();
}
