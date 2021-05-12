package com.hgn.apicidades.controllers;

import com.hgn.apicidades.entities.*;
import com.hgn.apicidades.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/states")
public class StateController {

  private final StateRepository repository;

  public StateController(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<State> states() {
    return repository.findAll();
  }
}
