package kz.iitu.liquor.eshop.controller;

import kz.iitu.liquor.eshop.dto.OrderDTO;
import kz.iitu.liquor.eshop.model.Order;
import kz.iitu.liquor.eshop.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private final IOrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public ResponseEntity<Order> create(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.save(orderDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        orderService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
