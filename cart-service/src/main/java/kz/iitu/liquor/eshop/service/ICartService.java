package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.CartDTO;
import kz.iitu.liquor.eshop.model.Cart;
import kz.iitu.liquor.eshop.model.Order;

import java.util.List;

public interface ICartService {

    Cart save(CartDTO cartDTO);
    Cart updateCart (Order order, Long cartId);
    void deleteById(Long id);
    Cart getById(Long id);

    List<Cart> getAll();
}
