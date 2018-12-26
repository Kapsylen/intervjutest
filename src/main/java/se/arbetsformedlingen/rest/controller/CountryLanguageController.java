package se.arbetsformedlingen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.arbetsformedlingen.rest.model.CountryLanguage;
import se.arbetsformedlingen.rest.service.CountryLanguageService;

@RestController
@RequestMapping("/countrylanguage")
public class CountryLanguageController {

    @Autowired
    CountryLanguageService countryLangService;

    @GetMapping(value = "/language/{name}")
    public CountryLanguage findByLanguage(@PathVariable(name = "name") String name){

        return countryLangService.findByLanguage(name);

    }


}
