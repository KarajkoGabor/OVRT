package hu.kutya.car.domain;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import org.springframework.util.Assert;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
abstract public class BaseCarPart implements CarPart {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private int price;

    private Set<CompatibilityHolder> compatibilities;

    public BaseCarPart(
            UUID id,
            int price,
            Set<CompatibilityHolder> compatibilities
    ) {
        Assert.notNull(id);
        Assert.isTrue(price >= 0);
        Assert.notEmpty(compatibilities);

        this.id = id;
        this.price = price;
        this.compatibilities = compatibilities;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isCompatibleWith(CarTemplate carTemplate, TrimLevel trimLevel) {
        return compatibilities.contains(new CompatibilityHolder(carTemplate, trimLevel));
    }

    public static class CompatibilityHolder {
        private CarTemplate carTemplate;
        private TrimLevel trimLevel;

        public CompatibilityHolder(CarTemplate carTemplate, TrimLevel trimLevel) {
            this.carTemplate = carTemplate;
            this.trimLevel = trimLevel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CompatibilityHolder that = (CompatibilityHolder) o;
            return Objects.equals(carTemplate, that.carTemplate) &&
                    Objects.equals(trimLevel, that.trimLevel);
        }

        @Override
        public int hashCode() {
            return Objects.hash(carTemplate, trimLevel);
        }
    }
}
