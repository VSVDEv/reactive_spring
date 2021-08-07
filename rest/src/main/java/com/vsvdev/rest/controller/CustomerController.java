package com.vsvdev.rest.controller;


import com.vsvdev.rest.model.Customer;
import com.vsvdev.rest.repo.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  CustomerRepository repository;

  @GetMapping
  public Flux<Customer> getCustomers(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Customer> getCustomer(@PathVariable Integer id){
    return repository.findById(id);
  }

  @PostMapping
  public Mono<Customer> createCustomer(@RequestBody Customer customer){
    return  repository.save(customer);
  }

  @PutMapping("/{id}")
  public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
    return repository.findById(id)
        .map((c) -> {
          c.setName(customer.getName());
          return c;
        }).flatMap( c -> repository.save(c));

  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteCustomer(@PathVariable Integer id){
    return repository.deleteById(id);
  }
}
