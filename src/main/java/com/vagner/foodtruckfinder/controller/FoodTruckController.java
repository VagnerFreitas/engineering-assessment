package com.vagner.foodtruckfinder.controller;

import com.vagner.foodtruckfinder.model.dto.TruckRatingDTO;
import com.vagner.foodtruckfinder.service.FoodtruckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foodtruck")
@AllArgsConstructor
@Slf4j
public class FoodTruckController {

    private FoodtruckService foodtruckService;

    @GetMapping
    @Operation(
            summary = "Finds all foodtrucks",
            description = "Finds all foodtrucks and order by rating.",
            tags = { "Trucks" },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json")
                    ),
                    @ApiResponse(description = "Internal error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<Page<TruckRatingDTO>> findAllTrucksOrderByAvgRatingDesc(
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {
        Page<TruckRatingDTO> truckList = foodtruckService.findAllTrucksOrderByAvgRatingDesc(size, page);
        return ResponseEntity.ok(truckList);
    }

}
