package de.atruvia.webappl.service;

import de.atruvia.webappl.service.model.Person;

public interface BlacklistService {

    boolean isAcceptable(Person person);
}
