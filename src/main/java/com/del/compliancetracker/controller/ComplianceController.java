package com.del.compliancetracker.controller;

import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.service.ComplianceService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService complianceService;

    // Constructor Injection (recommended way)
    public ComplianceController(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    // ✅ Create new compliance item
    @PostMapping
    public ComplianceItem create(@RequestBody ComplianceItem item) {
        item.setCreatedAt(LocalDateTime.now());
        return complianceService.create(item);
    }

    // ✅ Get all compliance items
    @GetMapping
    public List<ComplianceItem> getAll() {
        return complianceService.getAll();
    }

    // ✅ Get compliance item by ID
    @GetMapping("/{id}")
    public Optional<ComplianceItem> getById(@PathVariable Long id) {
        return complianceService.getById(id);
    }

    // ✅ Update compliance item
    @PutMapping("/{id}")
    public ComplianceItem update(@PathVariable Long id,
                                 @RequestBody ComplianceItem item) {
        return complianceService.update(id, item);
    }

    // ✅ Delete compliance item
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        complianceService.delete(id);
    }

    // ✅ Filter by status
    @GetMapping("/status/{status}")
    public List<ComplianceItem> getByStatus(@PathVariable String status) {
        return complianceService.getByStatus(status);
    }
}
