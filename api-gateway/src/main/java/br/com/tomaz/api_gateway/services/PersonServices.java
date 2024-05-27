package br.com.tomaz.api_gateway.services;


import br.com.tomaz.api_gateway.PersonRepository;
import br.com.tomaz.api_gateway.data.vo.v1.PersonVO;
import br.com.tomaz.api_gateway.data.vo.v2.PersonVOV2;
import br.com.tomaz.api_gateway.exceptions.ResourceNotFoundException;
import br.com.tomaz.api_gateway.mapper.ModelMapper;
import br.com.tomaz.api_gateway.mapper.custom.PersonMapper;
import br.com.tomaz.api_gateway.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    private final PersonRepository repository;
    private final PersonMapper mapper;

    public PersonServices(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PersonVO> findAll() {
        return ModelMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person ");

        var entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        return ModelMapper.parseObject(entity, PersonVO.class);
    }


    public PersonVO create(PersonVO person) {
        logger.info("Creating a person ");

        var entity = ModelMapper.parseObject(person, Person.class);

        return ModelMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update a person ");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return ModelMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(long id) {
        logger.info("Deleting one person ");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating a person with V2");

        var entity = mapper.convertVoToEntity(person);

        return mapper.convertEntityToVo(repository.save(entity));
    }
}
