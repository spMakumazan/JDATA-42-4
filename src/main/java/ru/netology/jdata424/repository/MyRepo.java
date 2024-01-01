package ru.netology.jdata424.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.jdata424.entity.Person;

import java.util.List;

@Repository
public class MyRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createNativeQuery(
                String.format("select * from PERSONS where city_of_living = '%s'", city)).getResultList();
    }
}
