package com.grocery.GroceryManagement.repository;

import com.grocery.GroceryManagement.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<Grocery, Long> {
}

