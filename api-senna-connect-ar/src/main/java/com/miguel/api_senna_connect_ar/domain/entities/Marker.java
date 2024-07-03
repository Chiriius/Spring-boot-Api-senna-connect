package com.miguel.api_senna_connect_ar.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "marker")
@Data
public class Marker {
    @Id
    @Column (name = "mar_id")
    private Long id;
    private String uid;
    @Column (name = "mar_name")
    private String name;
    @Column (name = "mar_description")
    private String description;

}
