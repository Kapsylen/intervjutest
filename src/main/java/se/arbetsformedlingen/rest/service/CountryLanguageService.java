package se.arbetsformedlingen.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.arbetsformedlingen.rest.model.CountryLanguage;
import se.arbetsformedlingen.rest.repository.CountryLanguageJpaRepository;

@Service
public class CountryLanguageService {

    @Autowired
    private CountryLanguageJpaRepository countryLanguageJpaRep;

    public CountryLanguage findByLanguage(String name){
      return  countryLanguageJpaRep.findByLanguage(name);
    }

}
