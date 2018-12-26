package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.arbetsformedlingen.rest.model.Country;
import se.arbetsformedlingen.rest.service.CountryService;

import java.util.List;


@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/find/{name}")
    @ResponseBody
    public ResponseEntity country(@PathVariable(value = "name", required = true) String name){
        return ResponseEntity.ok().body(countryService.findCountry(name));
    }

    //TODO: Controllers persists data via CountryJpaRepository


    @GetMapping(value = "/population/greaterthan/{population}")
    @ResponseBody
    public List<Country> findCountriesByPopulationIsGreaterThan (@PathVariable(value = "population") Integer population){
        return countryService.findCountriesByPopulationIsGreaterThan(population);
    }

    @GetMapping(value = "/governmentform/{govform}")
    public List<Country> findAllByGovernmentForm(@PathVariable(value = "govform") String govform){
        return countryService.findAllByGovernmentForm(govform);
    }

}
