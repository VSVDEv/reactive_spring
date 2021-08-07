package com.vsvdev.rest.repo;

import com.vsvdev.rest.model.Customer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

}
