package com.del.compliancetracker.repository;


import com.del.compliancetracker.model.ComplianceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplianceRepository extends JpaRepository<ComplianceItem, Long> {
    List<ComplianceItem> findByStatus(String status);

}
