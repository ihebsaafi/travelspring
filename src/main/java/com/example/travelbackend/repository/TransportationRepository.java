package com.example.travelbackend.repository;

import com.example.travelbackend.Entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportationRepository extends JpaRepository<Transportation, Long> {
}
