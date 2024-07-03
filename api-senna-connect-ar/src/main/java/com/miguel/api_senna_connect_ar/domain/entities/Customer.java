package com.miguel.api_senna_connect_ar.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Customer {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    
}



