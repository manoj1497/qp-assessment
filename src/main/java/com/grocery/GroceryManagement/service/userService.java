package com.grocery.GroceryManagement.service;

import com.grocery.GroceryManagement.entity.*;
import com.grocery.GroceryManagement.repository.GroceryItemRepository;
import com.grocery.GroceryManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class userService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(List<OrderRequest> orderRequest) {
        List<OrderItems> orderList = new ArrayList<>();
        double totalAmount = 0;

        // Get the userId from the first OrderRequest in the list
        long userId = orderRequest.get(0).getUserId();

        // Create the Order object and generate the orderId
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderId(generateOrderId()); // Method to generate orderId (e.g., UUID or sequence)

        for (OrderRequest orderRequestObj : orderRequest) {
            // Loop through the order items in the request and process them
            for (OrderItemRequest orderItemRequest : orderRequestObj.getOrderItems()) {
                System.out.println(orderItemRequest.getId());
                Grocery groceryItem = groceryItemRepository.findById(orderItemRequest.getId())
                        .orElseThrow(() -> new RuntimeException("Grocery item not found"));



                OrderItems orderItem = new OrderItems();
                orderItem.setUserId(orderRequest.get(0).getUserId());
                orderItem.setOrderID(order.getOrderId()); // Set the same orderId for all items
                orderItem.setItem_id(groceryItem.getId());
                orderItem.setName(groceryItem.getName());
                orderItem.setPrice(groceryItem.getPrice());
                orderItem.setQuantity(orderItemRequest.getQuantity());
                orderItem.setTotalPrice(groceryItem.getPrice() * orderItemRequest.getQuantity());
                orderItem.setDate(LocalDateTime.now());

                totalAmount += orderItem.getTotalPrice();
                orderList.add(orderItem);
            }
        }

        // Set the total amount and items for the order
        order.setItems(orderList);
        order.setTotalAmount(totalAmount);

        // Save all OrderItems
        orderRepository.saveAll(orderList);

        return order;
    }

    // Example method to generate an orderId (you can customize this)
    private String generateOrderId() {
        return "ORD-" + System.currentTimeMillis(); // Example using timestamp
    }
}
