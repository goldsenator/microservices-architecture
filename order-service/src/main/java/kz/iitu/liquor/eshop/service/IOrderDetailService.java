package kz.iitu.liquor.eshop.service;

import kz.iitu.liquor.eshop.dto.OrderDTO;
import kz.iitu.liquor.eshop.dto.OrderDetailDTO;
import kz.iitu.liquor.eshop.model.CartProduct;
import kz.iitu.liquor.eshop.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    OrderDetail save(OrderDetailDTO orderDetailDTO);
    OrderDetail update(OrderDTO orderDTO);
    void deleteById(Long id);
    OrderDetail getById(Long id);

    List<OrderDetail> getAll();

}
