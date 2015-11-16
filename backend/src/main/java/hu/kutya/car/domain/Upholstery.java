package hu.kutya.car.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Upholstery extends BaseCarPart {
    public Upholstery(UUID id, int price) {
        this(id, price, new HashSet<>());
    }

    public Upholstery(
            UUID id,
            int price,
            Set<CompatibilityHolder> compatibilities
    ) {
        super(id, price, compatibilities);
    }

    @Override
    public void visit(Car car) {
        car.setUpholstery(this);
    }
}
