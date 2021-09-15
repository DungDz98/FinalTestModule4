package spring.testcase.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Phải nhập số dương")
    private Long area;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Phải nhập số dương")
    private Long population;
    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Phải nhập số dương")
    private Long gdp;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "Không được để trống")
    private String description;

    @ManyToOne
    private Country country;

    public City() {
    }

    public City(String name, Long area, Long population, Long gdp, String description, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}