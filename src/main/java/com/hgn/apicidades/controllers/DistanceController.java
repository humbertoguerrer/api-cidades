package com.hgn.apicidades.controllers;

import com.hgn.apicidades.services.*;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distances")
public class DistanceController {

  private final DistanceService service;
  Logger log = LoggerFactory.getLogger(DistanceController.class);

  public DistanceController(DistanceService service) {
    this.service = service;
  }

  @GetMapping("/by-points")
  public ResponseEntity byPoints(
      @RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
    log.info("byPoints");
    return ResponseEntity.ok().body(service.distanceByPointsInMiles(city1, city2));
  }

  @GetMapping("/by-cube")
  public ResponseEntity byCube(
      @RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
    log.info("byCube");
    return ResponseEntity.ok(service.distanceByCubeInMeters(city1, city2));
  }
}
