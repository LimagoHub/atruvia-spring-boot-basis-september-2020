package de.atruvia.webappl.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@XmlRootElement
public class PersonDto {

    @Size(min = 36, max = 36)
    @NotNull
    private String id;

    @Size(max = 30)
    @NotNull
    private String vorname;

    @Size(max = 30)
    @NotNull
    private String nachname;
}
