package hu.kutya.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import hu.kutya.car.application.CarPartService;
import hu.kutya.car.application.CarService;
import hu.kutya.car.application.CarTemplateService;
import hu.kutya.car.domain.Car;
import hu.kutya.car.domain.CarPart;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.TrimLevel;
import hu.kutya.car.infrastructure.dto.output.CarOutput;
import hu.kutya.car.infrastructure.dto.output.CarTemplateOutput;
import hu.kutya.car.infrastructure.dto.output.TrimLevelOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarFacade {
    @Autowired
    private CarTemplateService carTemplateService;

    @Autowired
    private CarPartService carPartService;

    @Autowired
    private CarService carService;

    public List<CarTemplateOutput> getCarTemplates() {
        Set<CarTemplate> carTemplates = carTemplateService.getAll();

        return carTemplates.stream().map((Converter::convert)).collect(Collectors.toList());
    }

    public CarTemplateOutput getCarTemplate(UUID id) {
        return Converter.convert(carTemplateService.getById(id));
    }

    public CarOutput buildCar(UUID carTemplateId, UUID trimLevelId) {
        Car car = carService.createCar(carTemplateId, trimLevelId);
        return Converter.convert(car);
    }

    public CarOutput getCarById(UUID carId) {
        return Converter.convert(carService.getById(carId));
    }

    public CarOutput addPart(UUID carId, UUID partId) {
        Car car = carService.getById(carId);
        carService.addPartToCar(car, partId);

        return Converter.convert(car);
    }

    public Set<CarPart> getCompatibleCarParts(UUID carTemplateId, UUID trimLevelId) {
        CarTemplate carTemplate = carTemplateService.getById(carTemplateId);
        TrimLevel trimLevel = carTemplate.getTrimLevel(trimLevelId);

        return carPartService.getCompatibleCarParts(carTemplate, trimLevel);
    }

    private static class Converter {
        static CarTemplateOutput convert(CarTemplate carTemplate) {

            return new CarTemplateOutput(
                    carTemplate.getId(),
                    carTemplate.getImageUrl(),
                    carTemplate.getName(),
                    carTemplate.getMake(),
                    carTemplate.getBasePrice(),
                    carTemplate.getTrimLevels().stream().map(Converter::convert).collect(Collectors.toList())
            );
        }

        static TrimLevelOutput convert(TrimLevel trimLevel) {
            return new TrimLevelOutput(trimLevel.getId(), trimLevel.getPrice(), trimLevel.getName());
        }

        static CarOutput convert(Car car) {
            Set<CarPart> parts = new HashSet<>();
            parts.add(car.getEngine());
            parts.add(car.getTransmission());
            parts.add(car.getUpholstery());
            car.getRadio().ifPresent(parts::add);
            car.getGps().ifPresent(parts::add);
            car.getSpeakerSet().ifPresent(parts::add);

            return new CarOutput(
                    car.getId(),
                    car.getTemplate().getId(),
                    car.getTrimLevel().getId(),
                    car.getCreated(),
                    car.getModified(),
                    parts
            );
        }
    }
}
