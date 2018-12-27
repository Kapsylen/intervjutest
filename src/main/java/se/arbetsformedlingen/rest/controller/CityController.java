package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.arbetsformedlingen.rest.model.City;
import se.arbetsformedlingen.rest.service.CityService;

import java.util.List;


@RestController
@RequestMapping
public class CityController {

    @Autowired
    CityService service;


    @GetMapping(value = "/find/{name}")
    @ResponseBody
    public ResponseEntity city(@PathVariable(value = "name", required = true) String name){
        return ResponseEntity.ok().body(service.findCity(name));
    }



    //TODO: Controllers persists data via CityJpaRepository


    @PostMapping(value = "/city",  headers = "Accept=application/json")
    public City addCCity(@RequestBody City city) {
        return service.addCity(city);
    }

    @GetMapping(value = "/city/{name}")
    @ResponseBody
    public City findByName(@PathVariable(value = "name") String name){

        return service.findByName(name);
    }

    @GetMapping(value = "/city/code/{code}")
    @ResponseBody
    public List<City> findAllByCountryCode(@PathVariable(value = "code") String code){
        return service.findAllByCountryCode(code);
    }


    @GetMapping(value = "/city/region/{region}")
    @ResponseBody
    public List<City> findAllByCountryRegion(@PathVariable(value = "region") String region){
        return service.findAllByCountryRegion(region);
    }



}
