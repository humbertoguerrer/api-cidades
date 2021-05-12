package com.hgn.apicidades.controllers;

import com.hgn.apicidades.entities.State;
import com.hgn.apicidades.repositories.StateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateController {

  private final StateRepository repository;

  public StateController(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<State> staties() {
    return repository.findAll();
  }
}
