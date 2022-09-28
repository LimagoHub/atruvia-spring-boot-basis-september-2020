package de.atruvia.webappl.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
public class Person {

    private String id;


    private String vorname;


    private String nachname;


}
