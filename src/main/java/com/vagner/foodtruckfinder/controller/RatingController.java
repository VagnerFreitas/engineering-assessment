package com.vagner.foodtruckfinder.controller;

import com.vagner.foodtruckfinder.exception.NotFoundException;
import com.vagner.foodtruckfinder.model.Rating;
import com.vagner.foodtruckfinder.model.dto.RatingNewDto;
import com.vagner.foodtruckfinder.service.FoodtruckService;
import com.vagner.foodtruckfinder.service.RatingService;
import com.vagner.foodtruckfinder.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {

    private FoodtruckService foodtruckService;
    private UserService userService;

    private RatingService ratingService;

    @PostMapping
    @Operation(
            summary = "Rate food truck",
            description = "Rates a foodtruck.",
            tags = { "Rating" },
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RatingNewDto.class))
                    ),
                    @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Void> rateFoodTruck(@Valid @RequestBody RatingNewDto ratingNewDto, Principal principal) throws NotFoundException {
        Rating rating = Rating.builder()
                .truck(foodtruckService.findById(ratingNewDto.getTruckId()))
                .user(userService.findByEmail(principal.getName()).get())
                .rating(ratingNewDto.getRating())
                .build();
        ratingService.insert(rating);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
