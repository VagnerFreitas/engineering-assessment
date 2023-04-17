package com.vagner.foodtruckfinder.repository;

import com.vagner.foodtruckfinder.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
