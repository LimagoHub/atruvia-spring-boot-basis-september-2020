package de.atruvia.webappl.presentation.mapper;

import de.atruvia.webappl.presentation.dto.PersonDto;
import de.atruvia.webappl.service.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonDtoMapper {

    PersonDto convert(Person p);
    Person convert(PersonDto dto);

    Iterable<PersonDto> convert(Iterable<Person> personen);
}
