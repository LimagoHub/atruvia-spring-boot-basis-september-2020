package de.atruvia.webappl.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchweinDto {
    @Size(min = 36, max = 36)
    @NotNull
    private String id;
    @Size(max = 30)
    @NotNull
    private String name;

    @DecimalMin("10")
    private int gewicht;
}
