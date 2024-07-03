package com.miguel.api_senna_connect_ar.api.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.miguel.api_senna_connect_ar.domain.entities.Customer;
import com.miguel.api_senna_connect_ar.domain.repositories.CustomerRepository;

import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/customer")


public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/{id}")
    public Customer getCustomer(@RequestParam Long id) {
        return customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer don't exist"));
    }

    // @GetMapping("/email/{email}")
    // public Customer getByEmail(@RequestParam String email) {
    //     return customerRepository.findBy(Customer<"email">, email);
    // }
    
    


    @GetMapping("/get-all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @PostMapping("/add")
    public Customer postCustomer(@RequestBody Customer customer) {

        return customerRepository.save(customer);
    }
    
    
    
}
