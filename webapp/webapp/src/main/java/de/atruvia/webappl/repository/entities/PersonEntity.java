package de.atruvia.webappl.repository.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity // Pflichtattribut
@Table(name="tbl_personen")
public class PersonEntity {

    @Id // Pflichtattribut
    @Column(nullable = false, length = 36) // Nur beim Erstellen wirksam
    private String id;

    @Column(nullable = false, length = 30)
    private String vorname;

    @Column(nullable = false, length = 30)
    private String nachname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonEntity that = (PersonEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
