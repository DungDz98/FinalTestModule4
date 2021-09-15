package spring.testcase.service;

import spring.testcase.model.City;

import java.util.Optional;

public interface ICityService {
    Iterable<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    void deleteById(Long id);
}
