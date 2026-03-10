package com.product.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ordersystem.dto.ProductDTO;

@Repository
public interface ProductRepositoty extends JpaRepository<ProductDTO, Long> {

}
