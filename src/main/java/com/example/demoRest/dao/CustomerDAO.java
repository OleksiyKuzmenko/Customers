package com.example.demoRest.dao;

import com.example.demoRest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDAO extends JpaRepository<Customer, UUID> {
    List<Customer> findAllByIsActive(boolean isActive);

    Optional<Customer> findByIdAndIsActive(UUID id, boolean isActive);
}
