package com.example.travelbackend.repository;

import com.example.travelbackend.Entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
