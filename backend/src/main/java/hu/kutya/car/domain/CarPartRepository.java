package hu.kutya.car.domain;

import java.util.Set;
import java.util.UUID;

public interface CarPartRepository {
    CarPart getById(UUID id);
    Set<CarPart> getCompatiblePartsFor(CarTemplate carTemplate, TrimLevel trimLevel);
}
