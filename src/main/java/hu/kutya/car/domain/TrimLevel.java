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

    public TrimLevel(int price, String name) {
        this.id = UUID.randomUUID();
        this.price = price;
        this.name = name;
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

    //can be removed when a proper mongodb mapper is implemented
    //also we could think about a way of wrapping the class into a proxy to inject this functionality automatically
    @Deprecated
    public static class Restorer {
        public static TrimLevel restore(
                UUID id,
                String name,
                int price
        ) {
            TrimLevel trimLevel = new TrimLevel(price, name);
            trimLevel.id = id;

            return trimLevel;
        }
    }
}
