package com.example.risklog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Incident { 
    @Id
    @NotBlank(message = "id is required")
    @Size(max = 50, message = "id must be at most 50 characters")
    @Column(nullable = false, length = 50)
    private String id;

    @NotBlank(message = "description is required")
    @Size(max = 500, message = "description must be at most 500 characters")
    @Column(nullable = false, length = 500)
    private String description;

    @NotBlank(message = "severity is required")
    @Pattern(
            regexp = "(?i)LOW|MEDIUM|HIGH|CRITICAL",
            message = "severity must be one of: LOW, MEDIUM, HIGH, CRITICAL"
    )
    @Column(nullable = false, length = 20)
    private String severity;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}