package hu.kutya.car.infrastructure.dto.output;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import hu.kutya.car.domain.CarPart;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarOutput {
    @JsonProperty
    private UUID carId;
    @JsonProperty
    private UUID carTemplateId;
    @JsonProperty
    private UUID trimLevelId;
    @JsonProperty
    private Instant created;
    @JsonProperty
    private Instant modified;
    @JsonProperty
    private Set<CarPart> parts;

    public CarOutput(
            UUID carId,
            UUID carTemplateId,
            UUID trimLevelId,
            Instant created,
            Instant modified,
            Set<CarPart> parts
    ) {
        this.carId = carId;
        this.carTemplateId = carTemplateId;
        this.trimLevelId = trimLevelId;
        this.created = created;
        this.modified = modified;
        this.parts = parts;
    }

    public UUID getCarId() {
        return carId;
    }

    public UUID getCarTemplateId() {
        return carTemplateId;
    }

    public UUID getTrimLevelId() {
        return trimLevelId;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getModified() {
        return modified;
    }

    public Set<CarPart> getParts() {
        return parts;
    }
}
