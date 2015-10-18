package hu.kutya.car.domain;

import java.util.UUID;

public interface CarPart {
    UUID getId();
    int getPrice();
    void visit(Car car);
    boolean isCompatibleWith(CarTemplate carTemplate, TrimLevel trimLevel);
}
