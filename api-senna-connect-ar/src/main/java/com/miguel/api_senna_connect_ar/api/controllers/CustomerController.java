package com.miguel.api_senna_connect_ar.api.controllers;

import com.miguel.api_senna_connect_ar.api.models.responses.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RestController;
import com.miguel.api_senna_connect_ar.domain.entities.Customer;
import com.miguel.api_senna_connect_ar.domain.repositories.CustomerRepository;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Tag(name = "Customer")
@RestController
@RequestMapping( path = "customer")
@AllArgsConstructor
@NoArgsConstructor

public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @ApiResponse(
            responseCode = "400",
            description = "When the request have a field invalid we response this",
            content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorResponse.class))
            }
    )

    @Operation(summary = "Get customer by id")
    @GetMapping( path = "{id}")
    public Customer getCustomer(@RequestParam Long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer doesn't exist with with that id"));
    }

    


    @Operation(summary = "Get all customers")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @Operation(summary = "Add a new customer/user")
    @PostMapping()
    public ResponseEntity<CustomerResponse> postCustomer(@RequestBody Customer customer) {

        Customer savedCustomer= customerRepository.save(customer);
        CustomerResponse response = new CustomerResponse(savedCustomer,"Customer added successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable Long id){

        Customer customer = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer doesn't exist with with that id"));
        customerRepository.delete(customer);
        CustomerResponse response = new CustomerResponse(customer, "Customer deleted successfully");
        return ResponseEntity.ok(response);

    }
    
    
    
}
