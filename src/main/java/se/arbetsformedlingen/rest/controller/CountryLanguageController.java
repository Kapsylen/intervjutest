package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.arbetsformedlingen.rest.service.CountryLanguageService;

import java.util.List;

@RestController
@RequestMapping()
public class CountryLanguageController {

    @Autowired
    CountryLanguageService countryLangService;

    @GetMapping(value = "/language/{name}")
    public List<String> findOfficialLangByCountryName(@PathVariable(name = "name") String name){

        return countryLangService.findOfficialLangByCountryName(name);

    }



}
