package hu.kutya.car.domain;

import java.util.*;

import com.google.common.collect.ImmutableSet;

import org.springframework.util.Assert;

public class TrimLevel {
    private final UUID id;
    private final int price;
    private final String name;
    private final Engine engine;
    private final Transmission transmission;
    private final Upholstery upholstery;
    private final ImmutableSet<Accessory> accessories;

    private TrimLevel(
            UUID id,
            int price,
            String name,
            Engine engine,
            Transmission transmission,
            Upholstery upholstery,
            Collection<Accessory> accessories
    ) {
        Assert.notNull(id);
        Assert.isTrue(price >= 0);
        Assert.hasText(name);
        Assert.notNull(engine);
        Assert.notNull(transmission);
        Assert.notNull(upholstery);

        this.id = id;

        this.price = price;
        this.name = name;

        this.engine = engine;
        this.transmission = transmission;
        this.upholstery = upholstery;
        this.accessories = ImmutableSet.copyOf(accessories);
    }

    public UUID getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public Upholstery getUpholstery() {
        return upholstery;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrimLevel trimLevel = (TrimLevel) o;
        return Objects.equals(id, trimLevel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class Builder {
        private UUID id;
        private final int price;
        private final String name;
        private final Engine engine;
        private final Transmission transmission;
        private final Upholstery upholstery;

        private final Map<String, Accessory> accessories = new HashMap<>();

        public Builder(
                UUID id,
                int price,
                String name,
                Engine engine,
                Transmission transmission,
                Upholstery upholstery
        ) {
            this.id = id;
            this.price = price;
            this.name = name;
            this.engine = engine;
            this.transmission = transmission;
            this.upholstery = upholstery;
        }

        public Builder withAccessory(Accessory accessory) {
            Assert.notNull(accessory);

            if (accessories.putIfAbsent(accessory.getClass().getName(), accessory) != null) {
                throw new IllegalArgumentException(
                        "TrimLevel already contains an accessory of type: " + accessory.getClass().getName());
            }

            return this;
        }

        public TrimLevel build() {
            return new TrimLevel(id, price, name, engine, transmission, upholstery, accessories.values());
        }
    }
}
