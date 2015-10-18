package hu.kutya.car;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import hu.kutya.car.application.CarTemplateService;
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

    public List<CarTemplateOutput> getCarTemplates() {
        Set<CarTemplate> carTemplates = carTemplateService.getAll();

        return carTemplates.stream().map((Converter::convert)).collect(Collectors.toList());
    }

    public CarTemplateOutput getCarTemplate(UUID id) {
        return Converter.convert(carTemplateService.getById(id));
    }

    public List<TrimLevelOutput> getTrimLevelsOfCarTemplate(UUID carTemplateId) {
        CarTemplate carTemplate = carTemplateService.getById(carTemplateId);
        return carTemplate.getTrimLevels().stream().map(Converter::convert).collect(Collectors.toList());
    }

    public CarOutput buildCar(UUID carTemplateId, UUID trimLevelId) {
        /*
        CarTemplate carTemplate = carTemplateService.getById(carTemplateId);
        Optional<TrimLevel> trimLevel = carTemplate.getTrimLevels().stream().filter(internalTrimLevel -> {
            return internalTrimLevel
                    .getId().equals(trimLevelId);
        }).findFirst();

        if (trimLevel.isPresent)
        todo: finish this
        */

        return null;
    }

    private static class Converter {
        static CarTemplateOutput convert(CarTemplate carTemplate) {
            return new CarTemplateOutput(
                    carTemplate.getId(),
                    carTemplate.getImageUrl(),
                    carTemplate.getName(),
                    carTemplate.getMake(),
                    carTemplate.getBasePrice()
            );
        }

        static TrimLevelOutput convert(TrimLevel trimLevel) {
            return new TrimLevelOutput(trimLevel.getId(), trimLevel.getPrice(), trimLevel.getName());
        }
    }
}
