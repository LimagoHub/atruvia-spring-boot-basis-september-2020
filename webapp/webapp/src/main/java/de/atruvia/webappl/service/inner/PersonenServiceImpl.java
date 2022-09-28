package de.atruvia.webappl.service.inner;

import de.atruvia.webappl.repository.PersonenRepository;
import de.atruvia.webappl.service.PersonMapper;
import de.atruvia.webappl.service.PersonenService;
import de.atruvia.webappl.service.PersonenServiceException;
import de.atruvia.webappl.service.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = {PersonenServiceException.class}, isolation = Isolation.READ_COMMITTED)
public class PersonenServiceImpl implements PersonenService {

    private final PersonenRepository repo;
    private final PersonMapper mapper;

    private final List<String> antipathen;

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


        try {
            return speichernImpl(person);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Ein Fehler ist aufgetreten" , e);
        }
    }

    private boolean speichernImpl(Person person) throws PersonenServiceException {
        checkPerson(person);

        // Ermitteln ob das Element vor dem Speichern existiert
        boolean exists = repo.existsById(person.getId());

        repo.save(mapper.convert(person));

        return exists;
    }

    private void checkPerson(Person person) throws PersonenServiceException {
        validate(person);
        businessCheck(person);
    }

    private void businessCheck(Person person) throws PersonenServiceException {
        if(antipathen.contains(person.getVorname()))
            throw new PersonenServiceException("Antipath.");
    }

    private void validate(Person person) throws PersonenServiceException {
        if(person == null)
            throw new PersonenServiceException("Person darf nicht null sein.");

        if(person.getVorname() == null || person.getVorname().length() < 2)
            throw new PersonenServiceException("Vorname zu kurz.");

        if(person.getNachname() == null || person.getNachname().length() < 2)
            throw new PersonenServiceException("Nachname zu kurz.");
    }

    @Override
    @Transactional(rollbackFor = PersonenServiceException.class, isolation = Isolation.READ_UNCOMMITTED)
    public boolean loeschen(String id) throws PersonenServiceException {
        try {

            boolean exists = repo.existsById(id);
            repo.deleteById(id);

            return exists;
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler beim Loeschen" , e);
        }
    }

    @Override
    public Iterable<Person> findeAlle() throws PersonenServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler beim suchen" , e);
        }
    }

    @Override
    public Optional<Person> findeById(String id) throws PersonenServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        } catch (RuntimeException e) {
            throw new PersonenServiceException("Fehler beim suchen" , e);
        }
    }
}
