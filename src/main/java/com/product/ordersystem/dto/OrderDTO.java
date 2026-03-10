package com.product.ordersystem.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "orders")
public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "User must not be null")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDTO user;

    @Positive(message = "Total price must be greater than 0")
    private double totalPrice;

    @NotBlank(message = "Order status must not be empty")
    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();

    @NotEmpty(message = "Order must contain at least one item")
    @Valid
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemDTO> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderDTO [id=" + id + ", user=" + user + ", totalPrice=" + totalPrice +
                ", status=" + status + ", createdAt=" + createdAt + ", orderItems=" + orderItems + "]";
    }
}