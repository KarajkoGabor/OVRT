package hu.kutya.car.application;

import hu.kutya.car.domain.*;
import hu.kutya.car.exception.IncompatibleTrimLevelException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBuilder {
    @Autowired
    CarTemplateRepository carTemplateRepository;

    @Autowired
    CarPartRepository carPartRepository;

    public Car buildCar(BuildCarCommand buildCarCommand) {
        CarTemplate carTemplate = carTemplateRepository.getById(buildCarCommand.getCarTemplateId());
        TrimLevel trimLevel = null;

        for (TrimLevel carTemplateTrimLevel : carTemplate.getTrimLevels()) {
            if (carTemplateTrimLevel.getId().equals(buildCarCommand.getTrimLevelId())) {
                trimLevel = carTemplateTrimLevel;
                break;
            }
        }

        if (trimLevel == null) {
            throw new IncompatibleTrimLevelException();
        }

        return new Car(buildCarCommand.getCarId(), carTemplate, trimLevel, buildCarCommand.getCreated());
    }

    public void addPartToCar(Car car, AddPartToCarCommand addPartToCarCommand) {
        CarPart part = carPartRepository.getById(addPartToCarCommand.getPartId());
        car.accept(part);
        car.setModified(addPartToCarCommand.getCreated());
    }
}
