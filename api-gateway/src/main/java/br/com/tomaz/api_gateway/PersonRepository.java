package br.com.tomaz.api_gateway;

import br.com.tomaz.api_gateway.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}