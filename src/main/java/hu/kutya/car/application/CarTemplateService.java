package hu.kutya.car.application;

import java.util.Set;
import java.util.UUID;

import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.CarTemplateRepository;
import hu.kutya.car.exception.CarTemplateNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarTemplateService {
    @Autowired
    private CarTemplateRepository carTemplateRepository;

    public CarTemplate getById(UUID id) {
        CarTemplate ret = carTemplateRepository.getById(id);
        if (ret == null) {
            throw new CarTemplateNotFoundException();
        }

        return ret;
    }

    public Set<CarTemplate> getAll() {
        return carTemplateRepository.getCarTemplates();
    }
}
