package com.example.cust_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.cust_service.model.Cust;

@Repository
public interface CustRepository extends MongoRepository<Cust,String> {

}
