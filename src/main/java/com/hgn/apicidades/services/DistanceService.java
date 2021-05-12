package com.hgn.apicidades.services;

import com.hgn.apicidades.entities.*;
import com.hgn.apicidades.repositories.*;
import org.slf4j.*;
import org.springframework.data.geo.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class DistanceService {

  private final CityRepository cityRepository;
  Logger log = LoggerFactory.getLogger(DistanceService.class);

  public DistanceService(final CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public Double distanceByPointsInMiles(final Long city1, final Long city2) {
    log.info("nativePostgresInMiles({}, {})", city1, city2);
    return cityRepository.distanceByPoints(city1, city2);
  }

  public Double distanceByCubeInMeters(Long city1, Long city2) {
    log.info("distanceByCubeInMeters({}, {})", city1, city2);
    final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

    Point p1 = cities.get(0).getLocation();
    Point p2 = cities.get(1).getLocation();

    return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
}
