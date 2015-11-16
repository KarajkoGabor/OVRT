package hu.kutya.car.domain;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import hu.kutya.car.exception.IncompatibleCarPartException;

import org.springframework.util.Assert;

public class Car {
    private CarTemplate template;
    private TrimLevel trimLevel;
    private UUID id;
    private Engine engine;
    private Transmission transmission;
    private Upholstery upholstery;
    private Optional<GPS> gps = Optional.empty();
    private Optional<Radio> radio = Optional.empty();
    private Optional<SpeakerSet> speakerSet = Optional.empty();
    private Instant created;
    private Instant modified;

    public Car(UUID id, CarTemplate template, TrimLevel trimLevel, Instant created) {
        Assert.notNull(template);
        Assert.notNull(trimLevel);
        Assert.notNull(id);
        Assert.notNull(created);

        this.modified = Instant.from(created);
        this.created = Instant.from(created);
        this.id = id;
        this.template = template;
        this.trimLevel = trimLevel;

        this.engine = trimLevel.getEngine();
        this.transmission = trimLevel.getTransmission();
        this.upholstery = trimLevel.getUpholstery();

        for (Accessory accessory : trimLevel.getAccessories()) {
            if (accessory instanceof GPS) {
                this.gps = Optional.of((GPS) accessory);
            } else if (accessory instanceof Radio) {
                this.radio = Optional.of((Radio) accessory);
            } else if (accessory instanceof SpeakerSet) {
                this.speakerSet = Optional.of((SpeakerSet) accessory);
            } else {
                throw new IllegalArgumentException("Encountered unrecognized accessory");
            }
        }
    }

    public CarTemplate getTemplate() {
        return template;
    }

    public TrimLevel getTrimLevel() {
        return trimLevel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Upholstery getUpholstery() {
        return upholstery;
    }

    public Optional<GPS> getGps() {
        return gps;
    }

    void setGps(GPS gps) {
        this.gps = Optional.of(gps);
    }

    public Optional<Radio> getRadio() {
        return radio;
    }

    void setRadio(Radio radio) {
        this.radio = Optional.of(radio);
    }

    public Optional<SpeakerSet> getSpeakerSet() {
        return speakerSet;
    }

    void setSpeakerSet(SpeakerSet speakerSet) {
        this.speakerSet = Optional.of(speakerSet);
    }

    void setEngine(Engine engine) {
        this.engine = engine;
    }

    void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    void setUpholstery(Upholstery upholstery) {
        this.upholstery = upholstery;
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

    public Instant getCreated() {
        return created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = Instant.from(modified);
    }
}
