package com.product.ordersystem.serviceImpli;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.CartItemDTO;
import com.product.ordersystem.exception.ResourceNotFoundException;
import com.product.ordersystem.repository.CartItemRepository;
import com.product.ordersystem.service.CartItemService;

@Service
public class CartItemServiceImpli implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItemDTO addCartItem(CartItemDTO cartItemDTO) {

        CartItemDTO cartItem = new CartItemDTO();
        cartItem.setQuantity(cartItemDTO.getQuantity());

        CartItemDTO saved = cartItemRepository.save(cartItem);

        return new CartItemDTO(saved.getId(), null, null, saved.getQuantity());
    }

    @Override
    public CartItemDTO getCartItemById(Long id) {

        CartItemDTO cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + id));

        return new CartItemDTO(cartItem.getId(), null, null, cartItem.getQuantity());
    }

    @Override
    public List<CartItemDTO> getAllCartItems() {

        List<CartItemDTO> cartItems = cartItemRepository.findAll();

        return cartItems.stream()
                .map(item -> new CartItemDTO(
                        item.getId(),
                        null,
                        null,
                        item.getQuantity()))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {

        CartItemDTO cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + id));

        cartItem.setQuantity(cartItemDTO.getQuantity());

        CartItemDTO updated = cartItemRepository.save(cartItem);

        return new CartItemDTO(updated.getId(), null, null, updated.getQuantity());
    }

    @Override
    public void deleteCartItem(Long id) {

        CartItemDTO cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CartItem not found with id: " + id));

        cartItemRepository.deleteById(cartItem.getId());
    }

}