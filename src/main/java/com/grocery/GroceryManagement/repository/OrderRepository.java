package com.grocery.GroceryManagement.repository;

import com.grocery.GroceryManagement.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderItems, Long> {
}

