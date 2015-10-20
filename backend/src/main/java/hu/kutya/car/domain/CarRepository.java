package hu.kutya.car.domain;

import java.util.UUID;

public interface CarRepository {
    Car getById(UUID id);
}
