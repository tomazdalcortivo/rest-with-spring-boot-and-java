package br.com.tomaz.api_gateway.controllers;


import br.com.tomaz.api_gateway.model.Person;
import br.com.tomaz.api_gateway.services.PersonServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personServices.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return personServices.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return personServices.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return personServices.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personServices.delete(id);
    }

}
