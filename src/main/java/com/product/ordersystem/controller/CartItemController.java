package com.product.ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.ordersystem.dto.CartItemDTO;
import com.product.ordersystem.service.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCartItem(@RequestBody CartItemDTO cartItemDTO) {
        try {
            CartItemDTO saved = cartItemService.addCartItem(cartItemDTO);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding cart item: " + e.getMessage());
        }
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartItemById(@PathVariable Long id) {
        try {
            CartItemDTO cartItem = cartItemService.getCartItemById(id);
            return ResponseEntity.ok(cartItem);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cart item not found: " + e.getMessage());
        }
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<?> getAllCartItems() {
        try {
            List<CartItemDTO> list = cartItemService.getAllCartItems();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching cart items: " + e.getMessage());
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCartItem(@PathVariable Long id,
                                            @RequestBody CartItemDTO cartItemDTO) {
        try {
            CartItemDTO updated = cartItemService.updateCartItem(id, cartItemDTO);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating cart item: " + e.getMessage());
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Long id) {
        try {
            cartItemService.deleteCartItem(id);
            return ResponseEntity.ok("Cart Item deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting cart item: " + e.getMessage());
        }
    }

}