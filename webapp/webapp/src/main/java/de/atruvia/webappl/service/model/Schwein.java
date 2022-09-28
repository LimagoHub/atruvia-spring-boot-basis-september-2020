package de.atruvia.webappl.service.model;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class Schwein {

    @Setter(AccessLevel.PRIVATE)
    private String id;
    @Setter(AccessLevel.PRIVATE)
    private String name;
    @Setter(AccessLevel.PRIVATE)
    private int gewicht;

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }

    public void taufen(String neuerName) {
        if("Elsa".equals(neuerName))
            throw new IllegalArgumentException("Elsa heisst die Kuh. Der Name verstoesst gegen die Schweinewuerde");
        setName(neuerName);
    }
}
