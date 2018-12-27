package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.arbetsformedlingen.rest.model.Country;
import se.arbetsformedlingen.rest.service.CountryService;

import java.util.List;



@RestController
@RequestMapping
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/{name}")
    @ResponseBody
    public ResponseEntity find(@PathVariable(value = "name", required = true) String name){
        return ResponseEntity.ok().body(countryService.findCountry(name));
    }

    //TODO: Controllers persists data via CountryJpaRepository



    @GetMapping(value = "/countries")
    @ResponseBody
    public List<String> countries(){
        return countryService.listAllCountries();    }


    @GetMapping(value = "/country/{name}")
    @ResponseBody
    public List<Country> country(@PathVariable(value = "name", required = true) String name){
       return countryService.findCountry(name);
    }


    @PostMapping(value = "/countries", headers = "Accept=application/json")
    public Country add(@RequestBody Country country) {
        return countryService.addCountry(country);
    }


    @PutMapping(value = "/countries", headers = "Accept=application/json")
    public Country update(@RequestBody Country country) {
        return countryService.update(country);
    }

    @DeleteMapping(value = "/country/{name}")
    public void delete(@PathVariable(name = "name") String name){
        countryService.deleteCountry(name);
    }

    @GetMapping(value = "/population/greaterthan/{population}")
    @ResponseBody
    public List<Country> findCountriesByPopulationIsGreaterThan (@PathVariable(value = "population") Integer population){
        return countryService.findCountriesByPopulationIsGreaterThan(population);
    }

    @GetMapping(value = "/governmentform/{govform}")
    public List<Country> findAllByGovernmentForm(@PathVariable(value = "govform") String govform){
        return countryService.findAllByGovernmentForm(govform);
    }

    @GetMapping(value = "/capitals")
    public List<String> findAllCapitals(){
        return countryService.capitals();
    }

    @GetMapping(value = "/cities/{continent}/{population}")
    public List<Country> findAllCitiesInAContinentWithAPopulationEqualOrGreaterThanX(@PathVariable(value = "continent") String continent,
                                                                                     @PathVariable(value = "population") Integer population){
        return countryService.findAllCitiesInAContinentWithAPopulationEqualOrGreaterThanX(continent, population);
    }


}
