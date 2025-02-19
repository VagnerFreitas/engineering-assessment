package com.vagner.foodtruckfinder.repository;

import com.vagner.foodtruckfinder.model.Truck;
import com.vagner.foodtruckfinder.model.dto.TruckRatingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    @Query("SELECT " +
            "new com.vagner.foodtruckfinder.model.dto.TruckRatingDTO(" +
            "t.id, t.applicant, t.facilityType, t.locationDescription," +
            " t.address, t.foodItems, t.latitude," +
            " t.longitude, COALESCE(AVG(r.rating), 0) as avg_rating) " +
            "FROM Truck t LEFT JOIN t.ratings r " +
            "GROUP BY t.id, t.applicant " +
            "ORDER BY avg_rating DESC"
    )
    Page<TruckRatingDTO> findAllOrderByAvgRatingDesc(Pageable pageable);

}
