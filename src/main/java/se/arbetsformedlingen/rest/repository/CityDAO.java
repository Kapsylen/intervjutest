package se.arbetsformedlingen.rest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.arbetsformedlingen.rest.model.City;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CityDAO {
    @Autowired
    EntityManager em;


    public City findCity(String name){
        TypedQuery<City> query = em.createQuery(
                "SELECT c FROM City c WHERE c.name = :name", City.class);
        return query.setParameter("name", name).getSingleResult();
    }

    //TODO: use java persistence API to create more querries here

    public List<City> findAllCapitals() {

        TypedQuery<City> query = em.createQuery(
                "SELECT c.name FROM City c, Country k WHERE c.id = k.capital", City.class);
        return query.getResultList();
    }
    }




