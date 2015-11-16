package hu.kutya.car.domain;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public interface CarCommand {
    @Id
    String getId();
    UUID getCarId();
    Instant getCreated();
}
