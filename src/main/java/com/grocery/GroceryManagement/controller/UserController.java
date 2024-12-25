package com.grocery.GroceryManagement.controller;

import com.grocery.GroceryManagement.entity.Grocery;
import com.grocery.GroceryManagement.entity.Order;
import com.grocery.GroceryManagement.entity.OrderRequest;
import com.grocery.GroceryManagement.repository.GroceryItemRepository;
import com.grocery.GroceryManagement.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @GetMapping("/groceries")
    public ResponseEntity<List<Grocery>> viewAvailableGroceries() {
        return ResponseEntity.ok(groceryItemRepository.findAll());
    }

    @Autowired
    private userService orderService;

    @PostMapping("/place")
    public ResponseEntity<Object> placeOrder(@RequestBody List<OrderRequest> orderRequest) {
        if (orderRequest == null || orderRequest.isEmpty()) {
            return ResponseEntity.badRequest().body(null);  // Bad request if no items are provided
        }

        Order order = orderService.placeOrder(orderRequest);

        return ResponseEntity.ok(order);  // Return the order with total items and amount
    }


}
