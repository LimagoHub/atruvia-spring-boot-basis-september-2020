package de.atruvia.webappl;


import de.atruvia.webappl.repository.PersonEntity;
import de.atruvia.webappl.repository.PersonenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Demo {

    private final PersonenRepository repository;

    @PostConstruct
    public void postConstruct() {
        PersonEntity p = PersonEntity.builder().id("1").vorname("John").nachname("Doe").build();
        repository.save(p);


    }
}
