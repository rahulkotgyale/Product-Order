package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.CartDTO;

@Service
public interface CartDTOService {

	CartDTO createCart(CartDTO cart);

	CartDTO getCartById(Long id);

	List<CartDTO> getAllCarts();

	CartDTO updateCart(Long id, CartDTO cart);

	void deleteCart(Long id);

}
