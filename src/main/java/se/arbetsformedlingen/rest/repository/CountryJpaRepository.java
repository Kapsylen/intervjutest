package se.arbetsformedlingen.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.Country;

import java.util.List;

@Repository
public interface CountryJpaRepository extends JpaRepository<Country, Integer> {


    List<Country> findCountriesByPopulationIsGreaterThan(Integer population);

    List<Country> findAllByGovernmentForm(String name);

    @Query("SELECT c.name FROM City c, Country k where c.id = k.capital")
    List<String> findAllCapitals();

    //select distinct c.* from city c, country k where k.Continent = 'europe' AND  c.CountryCode = k.Code AND c.Population >= 1000000;

    @Query("SELECT c.name, c.population FROM City c, Country k where k.continent = :continent AND c.country = k.code AND c.population >= 1000000")
    List<Country> findAllCitiesInEuropeWithAPopulationOverAMillion(@Param("continent")String continent);

}
