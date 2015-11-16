package hu.kutya.car.domain;

import java.time.Instant;
import java.util.UUID;

import hu.kutya.car.application.CarBuilder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

@Document(collection = "car_events")
public class BuildCarCommand implements CarCommand {
    @Id
    private String id;

    private UUID carId;
    private UUID carTemplateId;
    private UUID trimLevelId;
    private Instant created;

    protected BuildCarCommand() {
    }

    public BuildCarCommand(UUID carTemplateId, UUID trimLevelId, UUID carId) {
        Assert.notNull(carTemplateId);
        Assert.notNull(trimLevelId);
        Assert.notNull(carId);

        this.carTemplateId = carTemplateId;
        this.trimLevelId = trimLevelId;
        this.carId = carId;
        this.created = Instant.now();
    }

    public UUID getCarTemplateId() {
        return carTemplateId;
    }

    public UUID getTrimLevelId() {
        return trimLevelId;
    }

    @Override
    public UUID getCarId() {
        return this.carId;
    }

    @Override
    public Instant getCreated() {
        return created;
    }
}
