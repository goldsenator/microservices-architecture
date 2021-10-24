package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.CartCategoryDTO;
import kz.iitu.liquor.eshop.model.CartCategory;

import java.util.List;

public interface ICartCategoryService {

    CartCategory save(CartCategoryDTO cartCategoryDTO);
    void deleteById(Long id);
    CartCategory getById(Long id);

    List<CartCategory> getAll();
}
