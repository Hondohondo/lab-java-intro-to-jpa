package com.ironhack.JPA.Assignment.repository;

import com.ironhack.JPA.Assignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerStatus(String customerStatus);
    List<Customer> findAllByCustomerStatus(String customerStatus);
    Optional<Customer> findByCustomerName(String customerName);
    List<Customer> findAllByCustomerNameContaining(String customerName);




}
