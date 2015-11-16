package hu.kutya.car.domain;

import java.util.Set;
import java.util.UUID;

abstract public class BaseAccessory extends BaseCarPart implements Accessory {
    public BaseAccessory(
            UUID id,
            int price,
            Set<CompatibilityHolder> compatibilities
    ) {
        super(id, price, compatibilities);
    }
}