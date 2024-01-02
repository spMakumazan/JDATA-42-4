package ru.netology.jdata424.controller;

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
    public List<Person> getPersons(@RequestParam("city") String city) {
        return myRepo.findByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersons(@RequestParam("age") int age) {
        return myRepo.findByAge(age);
    }

    @GetMapping("/persons/by-id")
    public Person getPersons(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") int age) {
        return myRepo.findByContact(name, surname, age).orElseThrow(NoPersonException::new);
    }
}
