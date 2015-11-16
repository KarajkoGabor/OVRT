package hu.kutya.car.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
public interface CarPart {
    UUID getId();
    int getPrice();
    void visit(Car car);
    boolean isCompatibleWith(CarTemplate carTemplate, TrimLevel trimLevel);
}
