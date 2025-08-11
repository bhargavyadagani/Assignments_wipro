package com.example.cust_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cust_service.model.Cust;
import com.example.cust_service.repository.CustRepository;

@Service
public class CustService {

	@Autowired
    private CustRepository custRepository;

    public Cust saveCustomer(Cust customer) {
        return custRepository.save(customer);
    }
}
