package com.example.cust_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cust_service.model.Cust;
import com.example.cust_service.service.CustService;

@RestController
@RequestMapping("/customers")
public class CustController {
	@Autowired
    private CustService custService;

    @PostMapping
    public Cust addCustomer(@RequestBody Cust customer) {
        return custService.saveCustomer(customer);
    }
}
