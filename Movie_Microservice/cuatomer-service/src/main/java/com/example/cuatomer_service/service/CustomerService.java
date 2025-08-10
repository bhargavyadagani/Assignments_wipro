package com.example.cuatomer_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cuatomer_service.model.Customer;
import com.example.cuatomer_service.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() 
    {
    	return customerRepository.findAll(); 
    }
    public Optional<Customer> getCustomerById(Long id)
    {
    	return customerRepository.findById(id);
    }
    public Customer saveCustomer(Customer customer) 
    { 
    	return customerRepository.save(customer);
    }
    public Customer updateCustomer(Long id, Customer customer) {
        Customer cust=customerRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Customer not found"));
        cust.setEmail(customer.getEmail());
        cust.setName(customer.getName());
        return customerRepository.save(cust);
    }
    public void deleteCustomer(Long id) 
    {
    	customerRepository.deleteById(id); 
    }
}

