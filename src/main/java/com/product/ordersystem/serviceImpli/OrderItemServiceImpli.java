package com.product.ordersystem.serviceImpli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.OrderItemDTO;
import com.product.ordersystem.exception.ResourceNotFoundException;
import com.product.ordersystem.service.OrderItemService;

@Service
public class OrderItemServiceImpli implements OrderItemService {

    private List<OrderItemDTO> orderItems = new ArrayList<>();

    // ADD ORDER ITEM
    @Override
    public Object addOrderItem(OrderItemDTO orderItemDTO) {

        orderItemDTO.setId((long) (orderItems.size() + 1));
        orderItems.add(orderItemDTO);

        return orderItemDTO;
    }

    // GET ORDER ITEM BY ID
    @Override
    public Object getOrderItemById(Long id) {

        for (OrderItemDTO item : orderItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }

        throw new ResourceNotFoundException("OrderItem not found with id: " + id);
    }

    // GET ALL ORDER ITEMS
    @Override
    public List<OrderItemDTO> getAllOrderItems() {

        return orderItems;
    }

    // UPDATE ORDER ITEM
    @Override
    public Object updateOrderItem(Long id, OrderItemDTO orderItemDTO) {

        for (OrderItemDTO item : orderItems) {

            if (item.getId().equals(id)) {

                item.setOrder(orderItemDTO.getOrder());
                item.setProduct(orderItemDTO.getProduct());
                item.setQuantity(orderItemDTO.getQuantity());
                item.setPrice(orderItemDTO.getPrice());

                return item;
            }
        }

        throw new ResourceNotFoundException("OrderItem not found with id: " + id);
    }

    // DELETE ORDER ITEM
    @Override
    public void deleteOrderItem(Long id) {

        boolean removed = orderItems.removeIf(item -> item.getId().equals(id));

        if (!removed) {
            throw new ResourceNotFoundException("OrderItem not found with id: " + id);
        }
    }

}