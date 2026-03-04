package com.example.risklog.service;

import com.example.risklog.model.Incident;
import com.example.risklog.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentService(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    public Iterable<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(Incident incident) {
        if (incidentRepository.existsById(incident.getId())) {
            throw new ResponseStatusException(CONFLICT, "Incident with id '" + incident.getId() + "' already exists");
        }

        incident.setSeverity(incident.getSeverity().trim().toUpperCase());
        return incidentRepository.save(incident);
    }
}