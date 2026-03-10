package com.product.ordersystem.serviceImpli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.ordersystem.dto.OrderDTO;
import com.product.ordersystem.dto.OrderItemDTO;
import com.product.ordersystem.dto.ProductDTO;
import com.product.ordersystem.repository.OrderRepository;
import com.product.ordersystem.repository.ProductRepositoty;
import com.product.ordersystem.service.OrderService;

@Service
public class OrderServiceImpli implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepositoty productRepository;

    // CREATE ORDER
    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {

        double totalPrice = 0;

        for (OrderItemDTO item : orderDTO.getOrderItems()) {

            ProductDTO product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Rule 1: Inventory must be available
            if (product.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient inventory for product: " + product.getName());
            }

            // Rule 2: Reduce inventory
            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);

            // Set order reference
            item.setOrder(orderDTO);

            // Set product price
            item.setPrice(product.getPrice());

            totalPrice += product.getPrice() * item.getQuantity();
        }

        orderDTO.setTotalPrice(totalPrice);
        orderDTO.setStatus("PLACED");

        return orderRepository.save(orderDTO);
    }

    // GET ORDER BY ID
    @Override
    public OrderDTO getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // GET ALL ORDERS
    @Override
    public List<OrderDTO> getAllOrders() {

        return orderRepository.findAll();
    }

    // UPDATE ORDER
    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {

        OrderDTO existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existingOrder.setStatus(orderDTO.getStatus());
        existingOrder.setOrderItems(orderDTO.getOrderItems());
        existingOrder.setTotalPrice(orderDTO.getTotalPrice());

        return orderRepository.save(existingOrder);
    }

    // DELETE ORDER
    @Override
    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);
    }
}