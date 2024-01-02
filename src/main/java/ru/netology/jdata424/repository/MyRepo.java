package ru.netology.jdata424.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.jdata424.entity.Contact;
import ru.netology.jdata424.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyRepo extends CrudRepository<Person, Contact> {
    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String city);

    @Query("select p from Person p where p.contact.age < :age order by p.contact.age")
    List<Person> findByAge(@Param("age") int age);

    @Query("select p from Person p where p.contact.name = :name and p.contact.surname = :surname and p.contact.age = :age")
    Optional<Person> findByContact(
            @Param("name") String name, @Param("surname") String surname, @Param("age") int age);
}
