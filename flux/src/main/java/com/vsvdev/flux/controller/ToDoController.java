package com.vsvdev.flux.controller;

import com.vsvdev.flux.model.ToDo;
import com.vsvdev.flux.repository.ToDoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
public class ToDoController {

  private ToDoRepository repository;

  public ToDoController(ToDoRepository repository){
    this.repository = repository;
  }

  @GetMapping("/todo/{id}")
  public Mono<ToDo> getToDo(@PathVariable String id){
    return this.repository.findById(id);
  }

  @GetMapping("/todo")
  public Flux<ToDo> getToDos(){
    return this.repository.findAll();
  }

}
