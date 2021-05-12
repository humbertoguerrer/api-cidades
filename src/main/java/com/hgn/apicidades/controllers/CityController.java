package com.hgn.apicidades.controllers;

import com.hgn.apicidades.entities.City;
import com.hgn.apicidades.repositories.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

