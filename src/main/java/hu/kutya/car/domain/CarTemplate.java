package hu.kutya.car.domain;

import java.util.*;

import com.google.common.collect.ImmutableSet;

import org.springframework.util.Assert;

public class CarTemplate {
    private UUID id;

    private String imageUrl;

    private String name;

    private String make;

    private int basePrice;

    private ImmutableSet<TrimLevel> trimLevels;

    CarTemplate() {
    }

    public CarTemplate(String imageUrl, String name, String make, Collection<TrimLevel> trimLevels) {
        Assert.hasText(imageUrl);
        Assert.hasText(name);
        Assert.hasText(make);
        Assert.notEmpty(trimLevels);

        this.id = UUID.randomUUID();
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


    //can be removed when a proper mongodb mapper is implemented
    //also we could think about a way of wrapping the class into a proxy to inject this functionality automatically
    @Deprecated
    public static class Restorer {
        public CarTemplate restore(
                UUID id,
                String imageUrl,
                String name,
                String make,
                Collection<TrimLevel> trimLevels
        ) {
            CarTemplate carTemplate = new CarTemplate(imageUrl, name, make, trimLevels);
            carTemplate.id = id;

            return carTemplate;
        }
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
