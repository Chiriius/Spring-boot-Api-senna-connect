package com.miguel.api_senna_connect_ar.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.api_senna_connect_ar.domain.entities.Marker;
import com.miguel.api_senna_connect_ar.domain.repositories.MarkerRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/marker")
@AllArgsConstructor
@NoArgsConstructor

public class MarkerController {

    @Autowired
    private MarkerRepository markerRepository;

    @GetMapping("get-all")
    public List<Marker> getMethodName() {
        return markerRepository.findAll();
    }
    
    
}
