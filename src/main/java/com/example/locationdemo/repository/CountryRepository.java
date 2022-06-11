package com.example.locationdemo.repository;

import com.example.locationdemo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByCode(String code);

    Country findByName(String name);
}