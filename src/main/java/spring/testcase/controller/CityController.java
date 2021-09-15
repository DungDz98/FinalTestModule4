package spring.testcase.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.testcase.model.City;
import spring.testcase.model.Country;
import spring.testcase.repository.ICountryRepository;
import spring.testcase.service.ICityService;
import spring.testcase.service.ICountryService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class CityController {
    @Autowired
    ICountryService countryService;
    @Autowired
    ICityService cityService;
    @ModelAttribute("countries")
    public ArrayList<Country> getCountries() {
        return (ArrayList<Country>) countryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("/home", "cities", (ArrayList<City>)cityService.findAll());
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create", "city", new City());
    }

    @PostMapping("/create-city")
    public ModelAndView createCity(@RequestParam("country") Long id , @Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/create", "city", city);
        }
        ModelAndView modelAndView = new ModelAndView("/home", "cities", (ArrayList<City>)cityService.findAll());
        modelAndView.addObject("checkCreate", "Thêm thành phố thành công");
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("/delete-city")
    public ModelAndView deleteCity(@RequestParam("id") Long id) {
        cityService.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("/home", "cities", (ArrayList<City>)cityService.findAll());
        modelAndView.addObject("checkDelete", "Xoá thành phố thành công");
        return modelAndView;
    }

    @GetMapping("/edit-city")
    public ModelAndView showEditForm(@RequestParam("id") Long id) {
        return new ModelAndView("/edit","city", cityService.findById(id).get());
    }

    @PostMapping("/edit-city")
    public ModelAndView editCity(@RequestParam("country") Long id , @Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/edit", "city", city);
        }
        ModelAndView modelAndView = new ModelAndView("/home", "cities", (ArrayList<City>)cityService.findAll());
        modelAndView.addObject("checkEdit", "Sửa thành phố thành công");
        cityService.save(city);
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam("id") Long id) {
        return new ModelAndView("/detail", "city", cityService.findById(id).get());
    }

}
