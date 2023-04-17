package com.vagner.foodtruckfinder.service;

import com.vagner.foodtruckfinder.exception.NotFoundException;
import com.vagner.foodtruckfinder.model.Truck;
import com.vagner.foodtruckfinder.model.dto.TruckRatingDTO;
import com.vagner.foodtruckfinder.repository.TruckRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class FoodtruckService {

    private TruckRepository truckRepository;


    public Page<TruckRatingDTO> findAllTrucksOrderByAvgRatingDesc(int size, int page) {
        return truckRepository.findAllOrderByAvgRatingDesc(PageRequest.of(page,size));
    }

    public Truck findById (Long id) throws NotFoundException {
        Optional<Truck> truck = truckRepository.findById(id);
        if(truck.isEmpty()){
            throw new NotFoundException(String.format("Truck with id %s not exists!",id));
        }

        return truck.get();
    }
}
