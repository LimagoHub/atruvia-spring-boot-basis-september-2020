package de.atruvia.webappl.repository;

import de.atruvia.webappl.repository.entities.PersonEntity;
import de.atruvia.webappl.repository.entities.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
// automatische Codegenerierung und Verwaltung von Spring weil es CrudRepository beerbt
public interface PersonenRepository extends CrudRepository<PersonEntity, String> {

    List<PersonEntity> findByVorname(String vorname);

    @Query("select pe from PersonEntity pe where pe.nachname = :nach")
    List<PersonEntity> xyz(String nach);


    // Nicht Typsicher weil ObjectArray
    @Query("select pe.id, pe.nachname from PersonEntity pe")
    List<Object[]> peter();


    // Typsicher weil konkrete Klasse
    @Query("select new de.atruvia.webappl.repository.entities.TinyPerson(pe.id,pe.nachname)  from PersonEntity pe")
    List<TinyPerson> findAllTinyPersons();
}
