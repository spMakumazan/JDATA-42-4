package ru.netology.jdata424.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.netology.jdata424.entity.Person;

import java.util.List;

@Repository
public class MyRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
         Query query = entityManager.createQuery("from Person where cityOfLiving = :city");
         query.setParameter("city", city);
         return query.getResultList();
    }
}
