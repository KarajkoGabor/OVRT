package hu.kutya.car.domain;

import java.util.Set;
import java.util.UUID;

public class SpeakerSet extends BaseAccessory {
    public SpeakerSet(
            UUID id,
            int price,
            Set<CompatibilityHolder> compatibilities
    ) {
        super(id, price, compatibilities);
    }

    @Override
    public void visit(Car car) {
        car.setSpeakerSet(this);
    }
}
