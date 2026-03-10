package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.OrderItemDTO;

@Service
public interface OrderItemService  {

	Object addOrderItem(OrderItemDTO orderItemDTO);

	Object getOrderItemById(Long id);

	List<OrderItemDTO> getAllOrderItems();

	Object updateOrderItem(Long id, OrderItemDTO orderItemDTO);

	void deleteOrderItem(Long id);

}
