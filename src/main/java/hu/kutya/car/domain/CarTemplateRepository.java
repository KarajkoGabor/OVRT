package hu.kutya.car.domain;

import java.util.UUID;

public interface CarTemplateRepository {
    CarTemplate getById(UUID uuid);
}
