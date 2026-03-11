package com.del.compliancetracker.controller;

import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.service.ComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService complianceService;

    @Autowired
    public ComplianceController(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    // GET all items
    @GetMapping
    public List<ComplianceItem> getAllItems() {
        return complianceService.getAll();
    }

    // GET single item by ID
    @GetMapping("/{id}")
    public ComplianceItem getItemById(@PathVariable Long id) {
        return complianceService.getById(id);
    }

    // GET paginated items
    @GetMapping("/pageable")
    public Page<ComplianceItem> getItemsPageable(Pageable pageable) {
        return complianceService.getAll(pageable);
    }

    // POST create new item
    @PostMapping
    public ComplianceItem createItem(@RequestBody ComplianceItem item) {
        return complianceService.save(item);
    }

    // PUT update existing item
    @PutMapping("/{id}")
    public ComplianceItem updateItem(@PathVariable Long id, @RequestBody ComplianceItem item) {
        return complianceService.update(id, item);
    }

    // DELETE item by ID
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        complianceService.deleteById(id);
        return "Item deleted successfully";
    }
}