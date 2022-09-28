package de.atruvia.webappl.service;

import de.atruvia.webappl.service.model.Person;

import java.util.Optional;

public interface PersonenService {

    boolean speichernOderAendern(Person person) throws PersonenServiceException ; // Alle moeglichen Dinge pruefen und an das Repo weiter reichen
    boolean loeschen(String id) throws PersonenServiceException;
    Iterable<Person> findeAlle() throws PersonenServiceException;
    Optional<Person> findeById(String id) throws PersonenServiceException;
}
