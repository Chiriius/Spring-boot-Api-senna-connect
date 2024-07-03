package com.miguel.api_senna_connect_ar.api.models.responses;

import java.io.Serializable;

import com.miguel.api_senna_connect_ar.domain.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponse implements Serializable {
    private Customer customer;
    private String message;
}
