package hu.kutya.car.domain;

import java.util.Set;

public interface CarPartRepository {
    CarPart getById();
    Set<CarPart> getCompatiblePartsFor(CarTemplate carTemplate, TrimLevel trimLevel);
}
