package se.arbetsformedlingen.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.Country;

import java.util.List;

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Integer> {


    List<Country> findCountriesByPopulationIsGreaterThan(Integer population);

    List<Country> findAllByGovernmentForm(String name);

    //select c.name from city c, country k where c.id = k.Capital;

    @Query("SELECT c.name FROM City c, Country k where c.id = k.capital")
    List<String> findAllCapitals();


}
