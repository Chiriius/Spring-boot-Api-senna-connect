package com.miguel.api_senna_connect_ar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.api_senna_connect_ar.api.models.responses.MarkerResponse;
import com.miguel.api_senna_connect_ar.domain.entities.Marker;
import com.miguel.api_senna_connect_ar.domain.repositories.MarkerRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@RestController
@RequestMapping( path = "marker")
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "Marker")
public class MarkerController {

    @Autowired
    private MarkerRepository markerRepository;

    @ApiResponse(
            responseCode = "400",
            description = "When the request have a field invalid we response this",
            content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorResponse.class))
            }
    )

    @Operation(summary = "Get all markers")
    @GetMapping
    public List<Marker> getAllMarkers() {
        return markerRepository.findAll();
    }
    
    @Operation(summary = "Get marker by id")
    @GetMapping(path = "{id}")
    public Marker getMarkerById(@PathVariable Long id) {
        return markerRepository.findById(id).orElseThrow(()-> new RuntimeException("Marker doesn't exist with with that id")) ;
    }

    @Operation(summary = "Add new Marker")
    @PostMapping()
    public ResponseEntity<MarkerResponse> postAddMarker(@RequestBody Marker marker) {

        Marker savedMarker = markerRepository.save(marker);
        MarkerResponse response = new MarkerResponse(savedMarker,"Marker added successfully");
        return ResponseEntity.ok(response);
    }

    @Operation (summary = "Update a existing Marker ")
    @PutMapping(path = "{id}")
    public ResponseEntity<MarkerResponse> putMarker(@RequestBody Marker detailsMarker, @PathVariable Long id){

        Marker marker = markerRepository.findById(id).orElseThrow(()-> new RuntimeException("Marker doesn't exist with with that id"));
        marker.setName(detailsMarker.getName());
        marker.setDescription(detailsMarker.getDescription());
        markerRepository.save(marker);
        MarkerResponse response = new MarkerResponse(marker,"Marker updated successfully");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete marker")
    @DeleteMapping (path = "{id}")
    public ResponseEntity<MarkerResponse> deleteMarker(@PathVariable Long id){
        Marker marker = markerRepository.findById(id).orElseThrow(()-> new RuntimeException("Marker doesn't exist with with that id"));
        markerRepository.delete(marker);
        MarkerResponse response = new MarkerResponse(marker, "Marker deleted successfully");
        return  ResponseEntity.ok(response);
    }
    
    
    
    
}
