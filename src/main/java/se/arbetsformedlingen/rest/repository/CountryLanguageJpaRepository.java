package se.arbetsformedlingen.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.CountryLanguage;

@Repository
public interface CountryLanguageJpaRepository extends JpaRepository<CountryLanguage, Integer> {
    CountryLanguage findByLanguage(String name);
}
