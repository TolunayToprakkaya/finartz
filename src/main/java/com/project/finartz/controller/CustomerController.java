package com.project.finartz.controller;

import com.project.finartz.base.dto.Customer;
import com.project.finartz.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/fetchAllCustomerList", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> fetchAllCustomerList() {
        return new ResponseEntity<>(customerService.fetchAllCustomerList(), HttpStatus.OK);
    }

    @GetMapping(value = "/inquireCustomerById/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> inquireCustomerById(@PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(customerService.inquireCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping(value = "/createCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(customerService.updateCustomer(customer, customerId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteCustomerById/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("customerId") Long customerId) {
        return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.OK);
    }
}
