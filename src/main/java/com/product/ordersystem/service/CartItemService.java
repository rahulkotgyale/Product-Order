package com.product.ordersystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.CartItemDTO;

@Service
public interface CartItemService {

	CartItemDTO addCartItem(CartItemDTO cartItemDTO);

	CartItemDTO getCartItemById(Long id);

	List<CartItemDTO> getAllCartItems();

	CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO);

	void deleteCartItem(Long id);


}
