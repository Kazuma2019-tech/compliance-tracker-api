package com.del.compliancetracker.controller;

import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.service.ComplianceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService complianceService;

    public ComplianceController(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    // Get all items
    @GetMapping
    public ResponseEntity<List<ComplianceItem>> getAllItems() {
        return ResponseEntity.ok(complianceService.getAll());
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<ComplianceItem> getItemById(@PathVariable Long id) {
        return complianceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new item
    @PostMapping
    public ResponseEntity<ComplianceItem> createItem(@RequestBody ComplianceItem item) {
        // No need to manually set createdAt
        ComplianceItem savedItem = complianceService.save(item);
        return ResponseEntity.ok(savedItem);
    }

    // Update item
    @PutMapping("/{id}")
    public ResponseEntity<ComplianceItem> updateItem(@PathVariable Long id, @RequestBody ComplianceItem updatedItem) {
        return complianceService.getById(id)
                .map(existingItem -> {
                    existingItem.setTitle(updatedItem.getTitle());
                    existingItem.setDescription(updatedItem.getDescription());
                    existingItem.setStatus(updatedItem.getStatus());
                    existingItem.setDueDate(updatedItem.getDueDate());
                    ComplianceItem savedItem = complianceService.save(existingItem);
                    return ResponseEntity.ok(savedItem);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        complianceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
