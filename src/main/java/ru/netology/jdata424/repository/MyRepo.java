package ru.netology.jdata424.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.netology.jdata424.entity.Contact;
import ru.netology.jdata424.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepo extends CrudRepository<Person, Contact> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByContactAgeLessThanOrderByContactAge(int age);

    Optional<Person> findByContactNameAndContactSurnameAndContactAge(String name, String surname, int age);
}
