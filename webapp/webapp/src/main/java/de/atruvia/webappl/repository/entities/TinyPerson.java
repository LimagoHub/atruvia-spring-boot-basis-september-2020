package de.atruvia.webappl.repository.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TinyPerson {

    private final String id;
    private final String nachname;
}
