package de.atruvia.webappl.presentation.controller;

import de.atruvia.webappl.presentation.dto.PersonDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/personen")
public class PersonenController {


    // Swagger annotationen
    @ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden")
    @ApiResponse(responseCode = "400", description = "Falsches Format")
    @ApiResponse(responseCode = "500", description = "interner Serverfehler")


    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
    public ResponseEntity<PersonDto> findById(@PathVariable  String id) {  // Erste Moeglichkeit Werte an Rest zu Uebergeben

        if("555".equals(id))
            return ResponseEntity.ok(PersonDto.builder().id(id).vorname("John").nachname("Doe").build());
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDto>> findAll(
            @RequestParam(name = "vorname",required = false, defaultValue = "") String vorname,
            @RequestParam(name = "nachname",required = false, defaultValue = "") String nachname
    ) { // Zweite Moeglichkeit Werte an Rest zu Uebergeben

        List<PersonDto> personen = List.of(
                PersonDto.builder().id("1").vorname("John").nachname("Doe").build(),
                PersonDto.builder().id("2").vorname("John").nachname("Wayne").build(),
                PersonDto.builder().id("3").vorname("Jane").nachname("Rambo").build(),
                PersonDto.builder().id("4").vorname("John").nachname("Wick").build(),
                PersonDto.builder().id("5").vorname("Jane").nachname("McClain").build()
        ).stream().filter(p->p.getVorname().equals(vorname)).collect(Collectors.toList());
        return ResponseEntity.ok(personen);
    }

    @DeleteMapping(path = "/{id}" )
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        if("555".equals(id)) {
            System.out.println("Person mit der ID " + id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
