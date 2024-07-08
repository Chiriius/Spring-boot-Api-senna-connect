package com.miguel.api_senna_connect_ar.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Data
@Builder
@Entity (name = "\"user\"")

public class Customer implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String uid;
    @Column(unique = true, length = 100, nullable = false)
    private String email;
    private String password;
    @Column(name = "nombre")
    private String firstname;
    @Column (name = "apellido")
    private String lastname;
    @Column (name = "departamento")
    private String departament;
    @Column (name = "ciudad")
    private String city;
    @Column (name = "barrio")
    private String hood;
    @Column (name = "direccion")
    private String address;
    @Column (name = "genero")
    private String sex;
    @Column (name = "rol")
    private Integer rol;
    @Column (name = "fechanacimiento")
    private LocalDate date;
    @Column (name = "fecharegistro")
    private LocalDateTime dateRegister;

    public Customer(){
        this.uid = UUID.randomUUID().toString();
    }


  
}



