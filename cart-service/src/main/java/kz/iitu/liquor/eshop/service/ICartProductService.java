package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.CartProductDTO;
import kz.iitu.liquor.eshop.model.CartProduct;

import java.util.List;

public interface ICartProductService {

    CartProduct save(CartProductDTO cartProductDTO);
    void deleteById(Long id);
    CartProduct getById(Long id);

    List<CartProduct> getAll();

}
