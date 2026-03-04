package com.example.risklog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.risklog.model.Incident;

public interface IncidentRepository extends JpaRepository<Incident, String> {
    // You can add custom query methods here if needed  

    
}
