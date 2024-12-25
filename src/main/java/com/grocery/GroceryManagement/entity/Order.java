package com.grocery.GroceryManagement.entity;

import java.util.List;

public class Order {

    private List<OrderItems> items; // List of ordered items
    private double totalAmount;    // Total price of the order
    private long userId;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    // Getters and setters
    public List<OrderItems> getItems() {
        return items;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setItems(List<OrderItems> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

