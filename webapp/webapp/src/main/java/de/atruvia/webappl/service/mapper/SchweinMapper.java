package de.atruvia.webappl.service.mapper;

import de.atruvia.webappl.repository.entities.SchweinEntity;
import de.atruvia.webappl.service.model.Schwein;

public interface SchweinMapper {



        SchweinEntity convert(Schwein Schwein);
        Schwein convert(SchweinEntity SchweinEntity);

        Iterable<Schwein> convert (Iterable<SchweinEntity> entities);
    }

