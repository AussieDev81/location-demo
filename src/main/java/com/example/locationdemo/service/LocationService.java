package com.example.locationdemo.service;

import com.example.locationdemo.entity.City;
import com.example.locationdemo.entity.Country;
import com.example.locationdemo.exception.CustomException;
import com.example.locationdemo.repository.CityRepository;
import com.example.locationdemo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LocationService {

    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private CityRepository cityRepository;


    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId).orElseThrow(EntityNotFoundException::new);
    }

    public Country updateCountry(Country country) {
        if(! countryRepository.existsById(country.getId()))
            throw new EntityNotFoundException("No Country with id "+ country.getId() +" could be found");
        else
            return countryRepository.save(country);
    }

    public String deleteCountryById(Long countryId) {
        if(! countryRepository.existsById(countryId))
            throw new EntityNotFoundException("Country with id="+ countryId +" was found, and so was not deleted");
        else{
            countryRepository.deleteById(countryId);
            return "Delete successful";
        }
    }

    public City saveCity(City city) {
        if(! countryRepository.existsByCode(city.getCountry().getCode())){
            countryRepository.save(city.getCountry());
        }
        else{
            city.setCountry(countryRepository.findByName(city.getCountry().getName()));
        }
        return cityRepository.save(city);
    }

    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(EntityNotFoundException::new);
    }

    public City updateCity(City city) {
        if(! cityRepository.existsById(city.getId()))
            throw new EntityNotFoundException("No City with id "+ city.getId() +" could be found");
        else
            return cityRepository.save(city);
    }

    public String deleteCityById(Long cityId) {
        if(! cityRepository.existsById(cityId))
            throw new EntityNotFoundException("City with id="+ cityId +" was found, and so was not deleted");
        else{
            cityRepository.deleteById(cityId);
            return "Delete successful";
        }
    }

    public Object throwCustomException() throws CustomException {
        throw new CustomException("This exception was thrown intentionally");
    }
}
