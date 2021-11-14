package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.InventoryDTO;
import kz.app.cart.shopping.model.InventoryItem;
import kz.app.cart.shopping.model.Order;

import java.util.List;

public interface InventoryServiceI {

    Inventory save(InventoryDTO inventoryDTO);
    void deleteById(Long id);
    Inventory getById(Long id);

    List<Inventory> getAll();
}
