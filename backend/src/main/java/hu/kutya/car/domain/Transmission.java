package hu.kutya.car.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.util.Assert;

public class Transmission extends BaseCarPart {

    @JsonProperty
    private int numOfSpeeds;

    public Transmission(UUID id, int price, int power) {
        this(id, price, power, new HashSet<>());
    }

    public Transmission(
            UUID id,
            int price,
            int numOfSpeeds,
            Set<CompatibilityHolder> compatibilities
    ) {
        super(id, price, compatibilities);

        Assert.isTrue(numOfSpeeds >= 0);
        this.numOfSpeeds = numOfSpeeds;
    }

    @Override
    public void visit(Car car) {
        car.setTransmission(this);
    }

    public int getNumOfSpeeds() {
        return numOfSpeeds;
    }
}
