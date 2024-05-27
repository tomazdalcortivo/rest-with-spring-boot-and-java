package br.com.tomaz.api_gateway.mapper;


import br.com.tomaz.api_gateway.data.vo.v1.PersonVO;
import br.com.tomaz.api_gateway.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ModelMapper {

    private static org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();

    static {
        mapper.createTypeMap(
                        Person.class,
                        PersonVO.class)
                .addMapping(Person::getId, PersonVO::setKey);
        mapper.createTypeMap(
                        PersonVO.class,
                        Person.class)
                .addMapping(PersonVO::getKey, Person::setId);
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();

        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
