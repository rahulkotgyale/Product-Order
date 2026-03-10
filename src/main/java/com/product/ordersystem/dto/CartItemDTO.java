package com.product.ordersystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="cart_item")
public class CartItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Cart must not be null")
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartDTO cart;

    @NotNull(message = "Product must not be null")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDTO product;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    public CartItemDTO(Long id, CartDTO cart, ProductDTO product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItemDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItemDTO [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
    }
}