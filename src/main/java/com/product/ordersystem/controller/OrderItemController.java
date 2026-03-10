package com.product.ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.ordersystem.dto.OrderItemDTO;
import com.product.ordersystem.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    // CREATE
    @PostMapping
    public Object addOrderItem(@RequestBody OrderItemDTO orderItemDTO) {

        try {
            return orderItemService.addOrderItem(orderItemDTO);
        } catch (Exception e) {
            return "Error creating order item: " + e.getMessage();
        }
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Object getOrderItemById(@PathVariable Long id) {

        try {
            return orderItemService.getOrderItemById(id);
        } catch (Exception e) {
            return "OrderItem not found: " + e.getMessage();
        }
    }

    // GET ALL
    @GetMapping
    public Object getAllOrderItems() {

        try {
            List<OrderItemDTO> list = orderItemService.getAllOrderItems();
            return list;
        } catch (Exception e) {
            return "Error fetching order items: " + e.getMessage();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public Object updateOrderItem(@PathVariable Long id,
                                  @RequestBody OrderItemDTO orderItemDTO) {

        try {
            return orderItemService.updateOrderItem(id, orderItemDTO);
        } catch (Exception e) {
            return "Error updating order item: " + e.getMessage();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Object deleteOrderItem(@PathVariable Long id) {

        try {
            orderItemService.deleteOrderItem(id);
            return "OrderItem deleted successfully";
        } catch (Exception e) {
            return "Error deleting order item: " + e.getMessage();
        }
    }

}