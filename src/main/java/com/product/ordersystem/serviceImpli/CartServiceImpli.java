package com.product.ordersystem.serviceImpli;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ordersystem.dto.CartDTO;
import com.product.ordersystem.exception.ResourceNotFoundException;
import com.product.ordersystem.repository.CartDTORepositoty;
import com.product.ordersystem.service.CartDTOService;

@Service
public class CartServiceImpli implements CartDTOService {

    @Autowired
    private CartDTORepositoty cartRepository;

    // CREATE CART
    @Override
    public CartDTO createCart(CartDTO cart) {
        return cartRepository.save(cart);
    }

    // GET CART BY ID
    @Override
    public CartDTO getCartById(Long id) {

        return cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));
    }

    // GET ALL CARTS
    @Override
    public List<CartDTO> getAllCarts() {

        return cartRepository.findAll();
    }

    // UPDATE CART
    @Override
    public CartDTO updateCart(Long id, CartDTO cart) {

        CartDTO existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));

        existingCart.setUser(cart.getUser());
        existingCart.setCartItems(cart.getCartItems());

        return cartRepository.save(existingCart);
    }

    // DELETE CART
    @Override
    public void deleteCart(Long id) {

        CartDTO cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found with id: " + id));

        cartRepository.delete(cart);
    }

}