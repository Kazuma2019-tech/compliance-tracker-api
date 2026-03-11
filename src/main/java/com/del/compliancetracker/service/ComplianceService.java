package com.del.compliancetracker.service;

import com.del.compliancetracker.exception.ResourceNotFoundException;
import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.repository.ComplianceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceService {

    private final ComplianceRepository complianceRepository;

    public ComplianceService(ComplianceRepository complianceRepository) {
        this.complianceRepository = complianceRepository;
    }

    // Save a new compliance item
    public ComplianceItem save(ComplianceItem item) {
        return complianceRepository.save(item);
    }

    // Get all items
    public List<ComplianceItem> getAll() {
        return complianceRepository.findAll();
    }

    // Get a single item by ID
    public ComplianceItem getById(Long id) {
        return complianceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compliance item not found with id: " + id));
    }

    // Update an existing item
    public ComplianceItem update(Long id, ComplianceItem updatedItem) {
        ComplianceItem existing = complianceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compliance item not found with id: " + id));

        existing.setTitle(updatedItem.getTitle());
        existing.setDescription(updatedItem.getDescription());
        existing.setStatus(updatedItem.getStatus());
        existing.setDueDate(updatedItem.getDueDate());

        return complianceRepository.save(existing);
    }

    // Delete an item by ID
    public void deleteById(Long id) {
        ComplianceItem existing = complianceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compliance item not found with id: " + id));
        complianceRepository.delete(existing);
    }

    // Get paginated items
    public Page<ComplianceItem> getAll(Pageable pageable) {
        return complianceRepository.findAll(pageable);
    }
}