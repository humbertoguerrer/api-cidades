package com.hgn.apicidades.repositories;

import com.hgn.apicidades.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
