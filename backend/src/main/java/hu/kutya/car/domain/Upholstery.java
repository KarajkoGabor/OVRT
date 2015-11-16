package hu.kutya.car.domain;

import java.util.Set;
import java.util.UUID;

import org.springframework.util.Assert;

public class Upholstery extends BaseCarPart {
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
