package hu.kutya.car.domain;

import java.util.Objects;
import java.util.UUID;

import hu.kutya.car.exception.IncompatibleCarPartException;

import org.springframework.util.Assert;

public class Car {
    private CarTemplate template;
    private TrimLevel trimLevel;
    private UUID id;
    //private Engine engine...

    public Car(CarTemplate template, TrimLevel trimLevel) {
        Assert.notNull(template);
        Assert.notNull(trimLevel);

        //todo: check that the trimLevel is actually compatible with the carTemplate
        this.template = template;
        this.trimLevel = trimLevel;
        this.id = UUID.randomUUID();
    }

    public CarTemplate getTemplate() {
        return template;
    }

    public TrimLevel getTrimLevel() {
        return trimLevel;
    }

    public UUID getId() {
        return id;
    }

    public void accept(CarPart carPart) {
        if (carPart.isCompatibleWith(template, trimLevel)) {
            carPart.visit(this);
        } else {
            throw new IncompatibleCarPartException();
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
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
