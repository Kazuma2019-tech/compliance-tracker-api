package com.del.compliancetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ComplianceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;

    private LocalDate dueDate;           // Only the date
    private LocalDateTime createdAt;     // Timestamp
    private LocalDateTime updatedAt;     // Timestamp

}