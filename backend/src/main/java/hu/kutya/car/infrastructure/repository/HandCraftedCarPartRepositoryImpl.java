package hu.kutya.car.infrastructure.repository;

import java.util.Set;

import hu.kutya.car.domain.CarPart;
import hu.kutya.car.domain.CarPartRepository;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.TrimLevel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("handCrafted")
//// TODO: 2015.10.18. implement these methods using hard coded data
public class HandCraftedCarPartRepositoryImpl implements CarPartRepository {
    @Override
    public CarPart getById() {
        return null;
    }

    @Override
    public Set<CarPart> getCompatiblePartsFor(
            CarTemplate carTemplate, TrimLevel trimLevel
    ) {
        return null;
    }
}
