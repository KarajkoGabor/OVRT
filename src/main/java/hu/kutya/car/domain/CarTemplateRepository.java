package hu.kutya.car.domain;

import java.util.Set;
import java.util.UUID;

public interface CarTemplateRepository {
    Set<CarTemplate> getCarTemplates();
    CarTemplate getById(UUID uuid);
}
