package de.atruvia.webappl.presentation.mapper;


import de.atruvia.webappl.presentation.dto.SchweinDto;
import de.atruvia.webappl.service.model.Schwein;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinDtoMapper {

    SchweinDto convert(Schwein p);
    Schwein convert(SchweinDto dto);

    Iterable<SchweinDto> convert(Iterable<Schwein> Schweinen);
}
