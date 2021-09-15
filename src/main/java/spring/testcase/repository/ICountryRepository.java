package spring.testcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.testcase.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Long> {
}
