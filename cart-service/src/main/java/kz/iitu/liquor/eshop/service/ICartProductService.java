package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CartProductDTO;
import kz.app.cart.shopping.model.CartProduct;

import java.util.List;

public interface ICartProductService {

    CartProduct save(CartProductDTO cartProductDTO);
    void deleteById(Long id);
    CartProduct getById(Long id);

    List<CartProduct> getAll();

}
