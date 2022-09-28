package de.atruvia.webappl.service.inner;

import de.atruvia.webappl.repository.PersonenRepository;
import de.atruvia.webappl.service.PersonenService;
import de.atruvia.webappl.service.PersonenServiceException;
import de.atruvia.webappl.service.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonenServiceImpl implements PersonenService {

    private final PersonenRepository repo;

    @Autowired
    public PersonenServiceImpl(final PersonenRepository repo) {
        this.repo = repo;
    }

    /*
        person == null -> PSE
        vorname == null -> PSE
        vorname < 2 Zeichen -> PSE
        nachname == null -> PSE
        nachname < 2 Zeichen -> PSE

        vorname Attila -> PSE

        Exceptions in underlying service -> PSE

        Happy Day -> Person an Repo übergeben

     */
    @Override
    public boolean speichernOderAendern(Person person) throws PersonenServiceException {
        return false;
    }

    @Override
    public boolean loeschen(String id) throws PersonenServiceException {
        return false;
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        return null;
    }

    @Override
    public Optional<Person> findeById(String id) throws PersonenServiceException {
        return Optional.empty();
    }
}
