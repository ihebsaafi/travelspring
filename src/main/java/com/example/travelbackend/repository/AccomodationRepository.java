package com.example.travelbackend.repository;

import com.example.travelbackend.Entity.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {
}
