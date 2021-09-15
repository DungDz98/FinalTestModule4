package spring.testcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.testcase.model.City;

public interface ICityRepository extends JpaRepository<City, Long> {
}
