package hu.kutya.car.domain;

import java.util.*;

import com.google.common.collect.ImmutableSet;
import hu.kutya.car.exception.TrimLevelNotFoundException;

import org.springframework.util.Assert;

public class CarTemplate {
    private UUID id;

    private String imageUrl;

    private String name;

    private String make;

    private int basePrice;

    private ImmutableSet<TrimLevel> trimLevels;

    private CarTemplate(UUID id, String imageUrl, String name, String make, Set<TrimLevel> trimLevels) {
        Assert.hasText(imageUrl);
        Assert.hasText(name);
        Assert.hasText(make);
        Assert.notEmpty(trimLevels);

        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.make = make;

        this.trimLevels = ImmutableSet.copyOf(trimLevels);
        this.basePrice = this.trimLevels.stream().min(Comparator.comparingInt(TrimLevel::getPrice)).get().getPrice();
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

    public Set<TrimLevel> getTrimLevels() {
        return trimLevels;
    }

    public TrimLevel getTrimLevel(UUID id) {
        for (TrimLevel trimLevel : trimLevels) {
            if (trimLevel.getId().equals(id)) {
                return trimLevel;
            }
        }

        throw new TrimLevelNotFoundException();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarTemplate that = (CarTemplate) o;
        return Objects.equals(id, that.id);
    }

    public static class Builder {
        private final UUID id;
        private final String imageUrl;
        private final String name;
        private final String make;

        private final Set<TrimLevel> trimLevels = new HashSet<>();

        public Builder(UUID id, String imageUrl, String name, String make) {
            this.id = id;
            this.imageUrl = imageUrl;
            this.name = name;
            this.make = make;
        }

        public Builder withTrimLevel(TrimLevel trimLevel) {
            Assert.notNull(trimLevel);

            if (!trimLevels.add(trimLevel)) {
                throw new IllegalArgumentException("CarTemplate already contains TrimLevel \"" + trimLevel.getName() + "\".");
            }

            return this;
        }

        public CarTemplate build() {
            return new CarTemplate(id, imageUrl, name, make, trimLevels);
        }
    }
}
