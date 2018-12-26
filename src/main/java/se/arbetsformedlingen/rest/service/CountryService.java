package se.arbetsformedlingen.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.arbetsformedlingen.rest.repository.CountryDAO;
import se.arbetsformedlingen.rest.model.Country;
import se.arbetsformedlingen.rest.repository.CountryJpaRepository;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDAO countryDAO;

    @Autowired
    CountryJpaRepository countryJpaRep;

    public Country findCountry(String name){
        Country country = countryDAO.findCountry(name);

        //Simple service logic
        country.setName(country.getName().toUpperCase());

        return country;

    }


    public List<Country> findCountriesByPopulationIsGreaterThan(Integer population) {

        return countryJpaRep.findCountriesByPopulationIsGreaterThan(population);

    }

    public List<Country> findAllByGovernmentForm(String name){

        return countryJpaRep.findAllByGovernmentForm(name);
    }


}
