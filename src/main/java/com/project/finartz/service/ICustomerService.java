package com.project.finartz.service;

import com.project.finartz.base.dto.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> fetchAllCustomerList();

    Customer inquireCustomerById(Long customerId);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer, Long customerId);

    Customer deleteCustomerById(Long customerId);
}
