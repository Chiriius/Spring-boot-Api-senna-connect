package com.miguel.api_senna_connect_ar.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguel.api_senna_connect_ar.domain.entities.Marker;

public interface MarkerRepository extends JpaRepository<Marker,Long> {
    
}
