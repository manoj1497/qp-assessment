package com.grocery.GroceryManagement.entity;

public class OrderItemRequest {

    private long id;       // The ID of the grocery item
    private int quantity;  // Quantity selected by the user

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

