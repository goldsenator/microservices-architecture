package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CartDTO;
import kz.app.cart.shopping.model.Cart;
import kz.app.cart.shopping.model.Order;

import java.util.List;

public interface ICartService {

    Cart save(CartDTO cartDTO);
    Cart updateCart (Order order, Long cartId);
    void deleteById(Long id);
    Cart getById(Long id);

    List<Cart> getAll();
}
