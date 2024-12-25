package com.grocery.GroceryManagement.entity;

import java.util.List;

public class OrderRequest {

    private long userId;  // The ID of the user placing the order
    private List<OrderItemRequest> orderItems;  // List of items the user is ordering

    // Getters and setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemRequest> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemRequest> orderItems) {
        this.orderItems = orderItems;
    }
}

