package com.del.compliancetracker.service;

import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.repository.ComplianceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComplianceService {

    private final ComplianceRepository complianceRepository;

    public ComplianceService(ComplianceRepository complianceRepository) {
        this.complianceRepository = complianceRepository;
    }

    // Create new item
    public ComplianceItem create(ComplianceItem item) {
        item.setCreatedAt(LocalDateTime.now());
        if (item.getDueDate() == null) {
            item.setDueDate(LocalDateTime.now().toLocalDate()); // default to today if not set
        }
        return complianceRepository.save(item);
    }

    // Update existing item
    public ComplianceItem update(Long id, ComplianceItem updatedItem) {
        Optional<ComplianceItem> optional = complianceRepository.findById(id);
        if (optional.isPresent()) {
            ComplianceItem existing = optional.get();
            existing.setTitle(updatedItem.getTitle());
            existing.setDescription(updatedItem.getDescription());
            existing.setStatus(updatedItem.getStatus());
            existing.setDueDate(updatedItem.getDueDate());
            existing.setUpdatedAt(LocalDateTime.now());
            return complianceRepository.save(existing);
        }
        return null;
    }

    // Get all items
    public List<ComplianceItem> getAll() {
        return complianceRepository.findAll();
    }

    // Get by status
    public List<ComplianceItem> getByStatus(String status) {
        return complianceRepository.findByStatus(status);
    }

    // Get by ID
    public Optional<ComplianceItem> getById(Long id) {
        return complianceRepository.findById(id);
    }

    // Delete
    public void delete(Long id) {
        complianceRepository.deleteById(id);
    }
}
