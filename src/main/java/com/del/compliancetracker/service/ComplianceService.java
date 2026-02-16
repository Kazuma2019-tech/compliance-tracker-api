package com.del.compliancetracker.service;

import com.del.compliancetracker.model.ComplianceItem;
import com.del.compliancetracker.repository.ComplianceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceService {

    private final ComplianceRepository complianceRepository;

    public ComplianceService(ComplianceRepository complianceRepository) {
        this.complianceRepository = complianceRepository;
    }

    public ComplianceItem save(ComplianceItem item) {
        // createdAt and updatedAt are automatically set by Hibernate
        return complianceRepository.save(item);
    }

    public List<ComplianceItem> getAll() {
        return complianceRepository.findAll();
    }

    public Optional<ComplianceItem> getById(Long id) {
        return complianceRepository.findById(id);
    }

    public void deleteById(Long id) {
        complianceRepository.deleteById(id);
    }
}
