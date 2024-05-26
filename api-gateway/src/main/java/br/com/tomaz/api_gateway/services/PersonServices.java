package br.com.tomaz.api_gateway.services;


import br.com.tomaz.api_gateway.model.Person;
import org.springframework.stereotype.Service;

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

}
