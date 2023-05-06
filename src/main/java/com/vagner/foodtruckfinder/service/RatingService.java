package com.vagner.foodtruckfinder.service;

import com.vagner.foodtruckfinder.model.Rating;
import com.vagner.foodtruckfinder.repository.RatingRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@SecurityRequirement(name = "foodtruckfinder")
@AllArgsConstructor
@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public Rating insert (Rating rating){
        return ratingRepository.save(rating);
    }
}
