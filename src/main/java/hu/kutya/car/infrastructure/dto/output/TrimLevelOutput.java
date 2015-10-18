package hu.kutya.car.infrastructure.dto.output;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrimLevelOutput {
    @JsonProperty
    private UUID id;

    @JsonProperty
    private int price;

    @JsonProperty
    private String name;

    public TrimLevelOutput(UUID id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
}
