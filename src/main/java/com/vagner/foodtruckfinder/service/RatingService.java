package com.vagner.foodtruckfinder.service;

import com.vagner.foodtruckfinder.model.Rating;
import com.vagner.foodtruckfinder.model.User;
import com.vagner.foodtruckfinder.model.dto.RatingNewDto;
import com.vagner.foodtruckfinder.model.dto.UserNewDto;
import com.vagner.foodtruckfinder.repository.RatingRepository;
import com.vagner.foodtruckfinder.repository.TruckRepository;
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
