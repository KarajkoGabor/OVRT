package hu.kutya.car.domain;


import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.util.Assert;

public class Engine extends BaseCarPart {

    @JsonProperty
    private int power;

    public Engine(UUID id, int price, int power) {
        this(id, price, power, new HashSet<>());
    }

    public Engine(
            UUID id,
            int price,
            int power,
            Set<CompatibilityHolder> compatibilities
    ) {
        super(id, price, compatibilities);

        Assert.isTrue(power >= 0);
        this.power = power;
    }

    @Override
    public void visit(Car car) {
        car.setEngine(this);
    }

    public int getPower() {
        return power;
    }
}
