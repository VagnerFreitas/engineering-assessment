package com.vagner.foodtruckfinder.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class RatingNewDto {
    @NotNull
    private Long truckId;
    @NotNull
    @Range(min = 1, max = 5)
    private Integer rating;
}
