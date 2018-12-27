package se.arbetsformedlingen.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.arbetsformedlingen.rest.model.City;
import se.arbetsformedlingen.rest.repository.CityDAO;
import se.arbetsformedlingen.rest.repository.CityJpaRepository;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityDAO cityDAO;

    @Autowired
    CityJpaRepository cityJpaRep;

    public City findCity(String name){
        City city = cityDAO.findCity(name);

        //Simple service logic
        city.setName(city.getName().toUpperCase());

        return city;

    }

    public City findByName(String name){

        return cityJpaRep.findByName(name);
    }


    public  List<City> findAllByCountryCode(String code){

        return cityJpaRep.findAllByCountryCode(code);
    }


    public List<City> findAllByCountryRegion(String region){

        return cityJpaRep.findAllByCountry_Region(region);
    }


    public City addCity(City city) {
        return cityJpaRep.save(city);
    }
}
