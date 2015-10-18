package hu.kutya.car.domain;

import java.util.Objects;
import java.util.UUID;

public class TrimLevel {
    private UUID id;
    private int price;
    private String name;
    //Engine, ...

    public UUID getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
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
}
