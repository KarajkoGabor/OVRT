package hu.kutya.car.domain;

import java.time.Instant;
import java.util.UUID;

public interface CarCommand {
    UUID getCarId();
    Instant getCreated();
}
