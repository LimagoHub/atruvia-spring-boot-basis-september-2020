package de.atruvia.webappl;



import de.atruvia.webappl.repository.PersonenRepository;
import de.atruvia.webappl.repository.entities.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Transactional
public class Demo {

    private final PersonenRepository repository;

    @PostConstruct
    public void postConstruct() {

        PersonEntity p = repository.findById("12345").get();



        p.setVorname("xxx");
    }
}
