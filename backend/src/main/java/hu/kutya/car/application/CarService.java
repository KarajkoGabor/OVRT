package hu.kutya.car.application;

import java.util.List;
import java.util.UUID;

import hu.kutya.car.domain.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    CarBuilder carBuilder;
    @Autowired
    CarEventRepository carEventRepository;

    public Car getById(UUID id) {
        List<CarCommand> commandList = carEventRepository.getByCarIdOrderByCreatedAsc(id);
        if (!(commandList.get(0) instanceof BuildCarCommand)) {
            throw new IllegalArgumentException("Expected BuildCarCommand to be the first element, got something else");
        }

        Car car = carBuilder.buildCar((BuildCarCommand) commandList.get(0));
        if (commandList.size() > 1) {
            for (int i = 1; i < commandList.size(); i++) {
                carBuilder.addPartToCar(car, (AddPartToCarCommand) commandList.get(i));
            }
        }

        return car;
    }

    public Car createCar(UUID carTemplateId, UUID trimLevelId) {
        BuildCarCommand command = new BuildCarCommand(carTemplateId, trimLevelId, UUID.randomUUID());

        carEventRepository.save(command);

        return carBuilder.buildCar(command);
    }

    public void addPartToCar(Car car, UUID partId) {
        AddPartToCarCommand command = new AddPartToCarCommand(car.getId(), partId);
        carEventRepository.save(command);

        carBuilder.addPartToCar(car, command);
    }
}
