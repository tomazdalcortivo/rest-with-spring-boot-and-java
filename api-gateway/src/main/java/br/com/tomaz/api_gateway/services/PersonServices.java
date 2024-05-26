package br.com.tomaz.api_gateway.services;


import br.com.tomaz.api_gateway.PersonRepository;
import br.com.tomaz.api_gateway.exceptions.ResourceNotFoundException;
import br.com.tomaz.api_gateway.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    private final PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person ");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }


    public Person create(Person person) {
        logger.info("Creating a person ");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update a person ");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
//        return repository.save(entity);
    }

    public void delete(long id) {
        logger.info("Deleting one person ");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

}
