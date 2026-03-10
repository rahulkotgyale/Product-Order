package com.product.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ordersystem.dto.OrderItemDTO;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemDTO, Long>{

}
