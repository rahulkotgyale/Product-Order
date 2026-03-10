package com.product.ordersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.product.ordersystem.dto.CartDTO;
import com.product.ordersystem.service.CartDTOService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartDTOService cartService;

    // CREATE CART
    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody CartDTO cart) {
        try {
            CartDTO savedCart = cartService.createCart(cart);
            return ResponseEntity.ok(savedCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating cart: " + e.getMessage());
        }
    }

    // GET CART BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable Long id) {
        try {
            CartDTO cart = cartService.getCartById(id);
            return ResponseEntity.ok(cart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Cart not found: " + e.getMessage());
        }
    }

    // GET ALL CARTS
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCarts() {
        try {
            List<CartDTO> carts = cartService.getAllCarts();
            return ResponseEntity.ok(carts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching carts: " + e.getMessage());
        }
    }

    // UPDATE CART
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCart(@PathVariable Long id, @RequestBody CartDTO cart) {
        try {
            CartDTO updatedCart = cartService.updateCart(id, cart);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating cart: " + e.getMessage());
        }
    }

    // DELETE CART
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id) {
        try {
            cartService.deleteCart(id);
            return ResponseEntity.ok("Cart deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting cart: " + e.getMessage());
        }
    }

}