package com.product.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.ordersystem.dto.UserDTO;

@Repository
public interface UserDtoRepository extends JpaRepository<UserDTO, Long> {



}
