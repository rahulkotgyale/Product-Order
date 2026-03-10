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
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="orderitem")
public class OrderItemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Order must not be null")
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderDTO order;

    @NotNull(message = "Product must not be null")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDTO product;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @Positive(message = "Price must be greater than 0")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItemDTO [id=" + id + ", order=" + order + ", product=" + product +
                ", quantity=" + quantity + ", price=" + price + "]";
    }
}