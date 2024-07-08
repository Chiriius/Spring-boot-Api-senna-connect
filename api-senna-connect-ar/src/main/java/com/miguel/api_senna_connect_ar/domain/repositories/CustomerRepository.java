package com.miguel.api_senna_connect_ar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguel.api_senna_connect_ar.domain.entities.Customer;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository <Customer, Long> {

    Optional<Customer> findByEmail(String email);
}
