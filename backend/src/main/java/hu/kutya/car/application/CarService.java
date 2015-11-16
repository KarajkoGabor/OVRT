package hu.kutya.car.application;

import java.util.UUID;

import hu.kutya.car.domain.AddPartToCarCommand;
import hu.kutya.car.domain.BuildCarCommand;
import hu.kutya.car.domain.Car;
import hu.kutya.car.domain.CarEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarBuilder carBuilder;
    @Autowired
    CarEventRepository carEventRepository;

    public Car getById(UUID id) {
        return null;
    }

    public Car createCar(UUID carTemplateId, UUID trimLevelId) {
        BuildCarCommand command = new BuildCarCommand(carTemplateId, trimLevelId, UUID.randomUUID());

        carEventRepository.save(command);

        return carBuilder.buildCar(command);
    }

    public void addPartToCar(Car car, UUID partId) {
        AddPartToCarCommand command = new AddPartToCarCommand(car.getId(), partId);
        carEventRepository.save(command);
    }
}
