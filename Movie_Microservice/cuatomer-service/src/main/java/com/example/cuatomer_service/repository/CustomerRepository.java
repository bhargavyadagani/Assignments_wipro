package com.example.cuatomer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cuatomer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
