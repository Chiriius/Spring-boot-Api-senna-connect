package com.miguel.api_senna_connect_ar.domain.entities;


import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Entity (name = "\"marker\"")
@Data
public class Marker  implements Serializable {
    @Id
    @Column (name = "mar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String uid;
    @Column (name = "mar_name")
    private String name;
    @Column (name = "mar_description")
    private String description;

    public Marker () {
    
        this.uid= UUID.randomUUID().toString();

    }

}
