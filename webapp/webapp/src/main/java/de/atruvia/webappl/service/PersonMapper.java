package de.atruvia.webappl.service;

import de.atruvia.webappl.repository.entities.PersonEntity;
import de.atruvia.webappl.service.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity convert(Person person);
    Person convert(PersonEntity personEntity);

    Iterable<Person> convert (Iterable<PersonEntity> entities);
 }
