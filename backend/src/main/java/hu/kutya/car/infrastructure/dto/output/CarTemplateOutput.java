package hu.kutya.car.infrastructure.dto.output;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.util.Assert;

public class CarTemplateOutput {
    @JsonProperty
    private UUID id;

    @JsonProperty
    private String imageUrl;

    @JsonProperty
    private String name;

    @JsonProperty
    private String make;

    @JsonProperty
    private int basePrice;

    private List<TrimLevelOutput> trimLevels;

    public CarTemplateOutput(UUID id, String imageUrl, String name, String make, int basePrice, List<TrimLevelOutput> trimLevels) {
        Assert.notNull(trimLevels);
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.make = make;
        this.basePrice = basePrice;
        this.trimLevels = trimLevels;
    }

    public UUID getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getMake() {
        return make;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public List<TrimLevelOutput> getTrimLevels() {
        return trimLevels;
    }
}