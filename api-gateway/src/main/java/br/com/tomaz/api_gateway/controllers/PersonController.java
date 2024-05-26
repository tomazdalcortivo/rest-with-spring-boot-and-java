package br.com.tomaz.api_gateway.controllers;


import br.com.tomaz.api_gateway.model.Person;
import br.com.tomaz.api_gateway.services.PersonServices;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) {
        return personServices.findById(id);
    }

}