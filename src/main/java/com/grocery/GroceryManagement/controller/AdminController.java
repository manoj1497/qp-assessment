package com.grocery.GroceryManagement.controller;


import com.grocery.GroceryManagement.entity.Grocery;
import com.grocery.GroceryManagement.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @PostMapping("/groceries")
    public ResponseEntity<Object> addGroceryItem(@RequestBody Grocery item) {
        Grocery savedItem = groceryItemRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/groceries")
    public ResponseEntity<List<Grocery>> viewAllGroceries() {
        return ResponseEntity.ok(groceryItemRepository.findAll());
    }

    @PutMapping("/groceries/{id}")
    public ResponseEntity<Grocery> updateGroceryItem(@PathVariable Long id, @RequestBody Grocery item) {
        return groceryItemRepository.findById(id).map(existingItem -> {
            existingItem.setName(item.getName());
            existingItem.setPrice(item.getPrice());
            existingItem.setInventory(item.getInventory());
            return ResponseEntity.ok(groceryItemRepository.save(existingItem));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/groceries/{id}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long id) {
        if (groceryItemRepository.existsById(id)) {
            groceryItemRepository.deleteById(id);
            return ResponseEntity.ok("Record deleted successfully");  // Return a success message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Grocery item not found");  // Return a failure message if the item doesn't exist
        }
    }
}
