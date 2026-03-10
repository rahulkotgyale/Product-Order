package com.product.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ordersystem.dto.CartDTO;

@Repository
public interface CartDTORepositoty extends JpaRepository<CartDTO, Long>{

}
