package com.hgn.apicidades.controllers;

import com.hgn.apicidades.entities.*;
import com.hgn.apicidades.repositories.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CityController {

  private final CityRepository repository;

  public CityController(final CityRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<City> cities(final Pageable page) {
    return repository.findAll(page);
  }
}
