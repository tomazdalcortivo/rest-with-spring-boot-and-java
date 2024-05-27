package br.com.tomaz.api_gateway.controllers;


import br.com.tomaz.api_gateway.data.vo.v1.PersonVO;
import br.com.tomaz.api_gateway.services.PersonServices;
import org.springframework.http.ResponseEntity;
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
    public PersonVO findById(@PathVariable Long id) {
        return personServices.findById(id);
    }

    @GetMapping
    public List<PersonVO> findAll() {
        return personServices.findAll();
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person) {
        return personServices.create(person);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO person) {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
