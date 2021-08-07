package com.vsvdev.flux.repository;

import com.vsvdev.flux.model.ToDo;

import java.util.Arrays;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ToDoRepository {

  private Flux<ToDo> toDoFlux = Flux.fromIterable(Arrays.asList(
      new ToDo("Do homework"),
      new ToDo("Workout in the mornings", true),
      new ToDo("Make dinner tonight"),
      new ToDo("Clean the studio", true)));


  public Mono<ToDo> findById(String id){
    return Mono.from(toDoFlux.filter( todo -> todo.getId().equals(id)));
  }

  public Flux<ToDo> findAll(){
    return toDoFlux;
  }
}
