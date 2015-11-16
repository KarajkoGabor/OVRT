package hu.kutya.car.domain;

import java.time.Instant;
import java.util.UUID;

import hu.kutya.car.application.CarBuilder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car_events")
public class AddPartToCarCommand implements CarCommand {
    @Id
    private String id;

    private UUID carId;

    private UUID partId;

    private Instant created;

    protected AddPartToCarCommand() {
    }

    public AddPartToCarCommand(UUID carId, UUID partId) {
        this.carId = carId;
        this.partId = partId;
        this.created = Instant.now();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public UUID getCarId() {
        return carId;
    }

    public UUID getPartId() {
        return partId;
    }

    @Override
    public Instant getCreated() {
        return created;
    }
}
