package ru.netology.jdata424.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdata424.entity.Person;
import ru.netology.jdata424.exeption.NoPersonException;
import ru.netology.jdata424.repository.MyRepo;

import java.util.List;

@RestController
public class MyController {

    private final MyRepo myRepo;

    public MyController(MyRepo myRepo) {
        this.myRepo = myRepo;
    }

    @GetMapping("/persons/by-city")
    @Secured("ROLE_READ")
    public List<Person> getPersons(@RequestParam("city") String city) {
        return myRepo.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    @RolesAllowed("WRITE")
    public List<Person> getPersons(@RequestParam("age") int age) {
        return myRepo.findByContactAgeLessThanOrderByContactAge(age);
    }

    @GetMapping("/persons/by-id")
    @PreAuthorize("hasRole('ROLE_DELETE')")
    public Person getPersons(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age) {
        return myRepo.findByContactNameAndContactSurnameAndContactAge(name, surname, age).orElseThrow(NoPersonException::new);
    }

    @GetMapping("/username")
    @PreAuthorize("#username == authentication.principal.username")
    public String greetingUser(@RequestParam("name") String username) {
        return "Hello from app, " + username;
    }
}
