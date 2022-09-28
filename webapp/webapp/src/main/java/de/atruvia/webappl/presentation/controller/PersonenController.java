package de.atruvia.webappl.presentation.controller;

import de.atruvia.webappl.presentation.dto.PersonDto;
import de.atruvia.webappl.presentation.mapper.PersonDtoMapper;
import de.atruvia.webappl.service.PersonenService;
import de.atruvia.webappl.service.PersonenServiceException;
import de.atruvia.webappl.service.model.Person;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonenController {

    private final PersonenService service;
    private final PersonDtoMapper mapper;

    // Swagger annotationen
    @ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden")
    @ApiResponse(responseCode = "400", description = "Falsches Format")
    @ApiResponse(responseCode = "500", description = "interner Serverfehler")


    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<PersonDto> findById(@PathVariable  String id) throws PersonenServiceException {  // Erste Moeglichkeit Werte an Rest zu Uebergeben
        return ResponseEntity.of(service.findeById(id).map(mapper::convert));
    }

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<PersonDto>> findAll(
            @RequestParam(name = "vorname",required = false, defaultValue = "") String vorname,
            @RequestParam(name = "nachname",required = false, defaultValue = "") String nachname
    ) throws PersonenServiceException{ // Zweite Moeglichkeit Werte an Rest zu Uebergeben

       return ResponseEntity.ok(mapper.convert(service.findeAlle()));
    }

    @DeleteMapping(path = "/{id}" )
    public ResponseEntity<Void> deleteById(@PathVariable String id) throws PersonenServiceException{
        if(service.loeschen(id)) {

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody PersonDto person,  final UriComponentsBuilder builder) throws PersonenServiceException{// Dritte Moeglichkeit Werte an Rest zu Uebergeben


        if(service.speichernOderAendern(mapper.convert(person)))
            // Update
            return ResponseEntity.ok().build();
        // Insert
        final var uri = builder.path("/v1/personen/{id}").buildAndExpand(person.getId());
        return ResponseEntity.created(uri.toUri()).build();
    }

//    @PutMapping(path="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> update(@Valid @RequestBody PersonDto person, @PathVariable String id) {
//        if("012345678901234567890123456789012345".equals(id)){
//
//            System.out.println(person + " wird geaendert");
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }

    // Ersatzget wenn Parameter OBJEKT

    // Keine Änderung auf der Serverseite
    @PostMapping(value = "/convert-to-upper", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDto> toUpper(@RequestBody PersonDto personDto) {
        personDto.setVorname(personDto.getVorname().toUpperCase());
        personDto.setNachname(personDto.getNachname().toUpperCase());
        return ResponseEntity.ok(personDto);
    }
}
