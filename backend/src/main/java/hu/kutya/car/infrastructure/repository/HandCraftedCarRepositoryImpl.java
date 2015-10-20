package hu.kutya.car.infrastructure.repository;

import java.util.UUID;

import hu.kutya.car.domain.Car;
import hu.kutya.car.domain.CarRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("handCrafted")
//// TODO: 2015.10.18. implement these methods using hard coded data
public class HandCraftedCarRepositoryImpl implements CarRepository {
    @Override
    public Car getById(UUID id) {
        return null;
    }
}
