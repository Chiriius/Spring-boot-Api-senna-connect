package com.miguel.api_senna_connect_ar.api.models.responses;

import java.io.Serializable;

import com.miguel.api_senna_connect_ar.domain.entities.Marker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MarkerResponse implements Serializable {

    private Marker marker;
    private String message;
    
}
