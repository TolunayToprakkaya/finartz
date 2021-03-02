package com.project.finartz.service.impl;

import com.project.finartz.base.dto.Customer;
import com.project.finartz.base.mapper.DozerMapperUtility;
import com.project.finartz.entity.CustomerEntity;
import com.project.finartz.repository.CustomerRepository;
import com.project.finartz.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DozerMapperUtility dozerMapperUtility;

    private static final String mapId = "CustomerEntity_Customer";

    @Override
    public List<Customer> fetchAllCustomerList() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();

        return dozerMapperUtility.map(customerEntityList, Customer.class, mapId);
    }

    @Override
    public Customer inquireCustomerById(Long customerId) {
        CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);

        return dozerMapperUtility.map(customerEntity, Customer.class, mapId);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = dozerMapperUtility.map(customer, CustomerEntity.class, mapId);
        customerRepository.save(customerEntity);

        return dozerMapperUtility.map(customerEntity, Customer.class, mapId);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Customer customer, Long customerId) {
        CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
        customerEntity.setName(customer.getName());
        customerEntity.setLastname(customer.getLastname());
        customerEntity.setAge(customer.getAge());
        customerEntity.setGender(customer.getGender());
        customerRepository.save(customerEntity);

        return dozerMapperUtility.map(customerEntity, Customer.class, mapId);
    }

    @Override
    public Customer deleteCustomerById(Long customerId) {
        CustomerEntity customerEntity = customerRepository.findByCustomerId(customerId);
        customerRepository.deleteById(customerId);

        return dozerMapperUtility.map(customerEntity, Customer.class, mapId);
    }
}
