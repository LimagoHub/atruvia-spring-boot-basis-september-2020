package de.atruvia.webappl.presentation.controller;


import de.atruvia.webappl.presentation.dto.PersonDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/demo")
public class DemoController {



    @GetMapping(path="/gruss")
    //@RequestMapping(path="gruss", method= RequestMethod.GET) // Veraltet
    // http://localhost:8080/demo/gruss ruft diese Methode auf
    public String schallUndRauch() {

        return "Hallo Rest";
    }

    @GetMapping(path="/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDto getPerson() {
        return PersonDto.builder().id("1").vorname("Jane").nachname("Doe").build();
    }
}
