package spring.testcase.service;

import spring.testcase.model.City;
import spring.testcase.model.Country;

import java.util.Optional;

public interface ICountryService {
    Iterable<Country> findAll();
    Optional<Country> findById(Long id);
    Country save(Country country);
    void deleteById(Long id);
}
