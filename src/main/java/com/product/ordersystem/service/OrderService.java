package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.OrderDTO;

@Service
public interface OrderService {

	OrderDTO createOrder(OrderDTO orderDTO);

	OrderDTO getOrderById(Long id);

	List<OrderDTO> getAllOrders();

	OrderDTO updateOrder(Long id, OrderDTO orderDTO);

	void deleteOrder(Long id);

}
