package kz.iitu.liquor.eshop.dto;


import kz.iitu.liquor.eshop.dto.InventoryDTO;
import kz.iitu.liquor.eshop.model.InventoryItem;
import kz.iitu.liquor.eshop.model.Order;

import java.util.List;

public interface InventoryServiceI {

    Inventory save(InventoryDTO inventoryDTO);
    void deleteById(Long id);
    Inventory getById(Long id);

    List<Inventory> getAll();
}