package hu.kutya.car.application;

import java.util.Set;

import hu.kutya.car.domain.CarPart;
import hu.kutya.car.domain.CarPartRepository;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.TrimLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarPartService {
    @Autowired
    private CarPartRepository carPartRepository;

    public Set<CarPart> getCompatibleCarParts(CarTemplate carTemplate, TrimLevel trimLevel) {
        return carPartRepository.getCompatiblePartsFor(carTemplate, trimLevel);
    }
}
