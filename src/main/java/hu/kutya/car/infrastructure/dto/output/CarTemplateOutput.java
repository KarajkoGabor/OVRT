package hu.kutya.car.infrastructure.dto.output;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public CarTemplateOutput(UUID id, String imageUrl, String name, String make, int basePrice) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.make = make;
        this.basePrice = basePrice;
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
}