package br.com.tomaz.api_gateway.services;


import br.com.tomaz.api_gateway.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong count = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person ");
        Person person = new Person();
        person.setId(count.incrementAndGet());
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress("Uberlandia - Minas Gerais - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all persons ");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("Creating a person ");
        return person;
    }

    public Person update(Person person) {
        logger.info("Update a person ");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person ");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(count.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address in Brazil");
        person.setGender("Male");
        return person;
    }


}
