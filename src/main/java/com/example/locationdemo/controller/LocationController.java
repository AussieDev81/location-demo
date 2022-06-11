package com.example.locationdemo.controller;

import com.example.locationdemo.entity.City;
import com.example.locationdemo.entity.Country;
import com.example.locationdemo.exception.CustomException;
import com.example.locationdemo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/country")
    private ResponseEntity<Country> saveCountry(@RequestBody Country country){
        return ResponseEntity.ok(locationService.saveCountry(country));
    }

    @GetMapping("/country/{id}")
    private ResponseEntity<Country> getCountryById(@PathVariable("id") Long countryId){
        return ResponseEntity.ok(locationService.getCountryById(countryId));
    }

    @PutMapping("/country")
    private ResponseEntity<Country> updateCountry(@RequestBody Country country){
        return ResponseEntity.ok(locationService.updateCountry(country));
    }

    @DeleteMapping("/country/{id}")
    private ResponseEntity<String> deleteCountry(@PathVariable("id") Long countryId){
        return ResponseEntity.ok(locationService.deleteCountryById(countryId));
    }

    @PostMapping("/city")
    private ResponseEntity<City> saveCity(@RequestBody City city){
        return ResponseEntity.ok(locationService.saveCity(city));
    }

    @GetMapping("/city/{id}")
    private ResponseEntity<City> getCityById(@PathVariable("id") Long cityId){
        return ResponseEntity.ok(locationService.getCityById(cityId));
    }

    @PutMapping("/city")
    private ResponseEntity<City> updateCity(@RequestBody City city){
        return ResponseEntity.ok(locationService.updateCity(city));
    }

    @DeleteMapping("/city/{id}")
    private ResponseEntity<String> deleteCityById(@PathVariable("id") Long cityId){
        return ResponseEntity.ok(locationService.deleteCityById(cityId));
    }

    @GetMapping("/throw")
    public ResponseEntity<?> throwException() throws CustomException {
        return ResponseEntity.badRequest().body(locationService.throwCustomException());
    }
}
