package hu.kutya.car.infrastructure.repository;

import java.util.*;

import hu.kutya.car.domain.CarPart;
import hu.kutya.car.domain.CarPartRepository;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.TrimLevel;
import hu.kutya.car.exception.CarPartNotFoundException;

public class HandCraftedCarPartRepositoryImpl implements CarPartRepository {
    public static final UUID racingEngineId = UUID.fromString("5e757606-fb53-4d5f-95b9-760122cabf38");
    public static final UUID ecoEngineId = UUID.fromString("44796440-5e2e-4c74-90b0-aca682f58df7");
    public static final UUID streetEngineId = UUID.fromString("c778ccd6-5f8f-48cb-9c09-195ce97c3d4d");
    public static final UUID offRoadEngineId = UUID.fromString("e4a7f0ee-9c61-4a1e-9257-ab36653cf121");

    public static final UUID goodTransmissionId = UUID.fromString("bedac89b-874d-43ed-918a-efd29113cc30");
    public static final UUID badTransmissionId = UUID.fromString("05e34936-dcb7-40ca-9a65-429971009f24");
    public static final UUID luxuryTransmissionId = UUID.fromString("3de505c4-a1c0-471f-9a5e-51696157477d");

    public static final UUID normalUpholsteryId = UUID.fromString("bf0a3290-39b6-4e8c-a499-4563c37a0a73");
    public static final UUID cheapUpholsteryId = UUID.fromString("3e8f9857-9a11-4531-837f-52b285c3f5f30");
    public static final UUID luxuryUpholsteryId = UUID.fromString("dcbcfd72-195a-4c17-beb3-18a27ba7512d");

    public static final UUID romanianRadioId = UUID.fromString("28b418a8-3f6a-49bb-a51a-70930d41c20f");
    public static final UUID polishRadioId = UUID.fromString("e98842ae-b8b2-49a0-8d05-a301e3ab5252");
    public static final UUID luxuryRadioId = UUID.fromString("b86cb50f-3a70-4513-83b4-f19c6d8e25a6");
    public static final UUID goodRadioId = UUID.fromString("f9208451-4c2b-4bca-9ae3-7ec77ea30af4");

    public static final UUID normalGPSId = UUID.fromString("261137af-20da-459e-b072-9ba1d41c76e1");
    public static final UUID luxuryGPSId = UUID.fromString("c92ff725-9d1c-48e1-b340-819d371e5bf5");

    public static final UUID luxurySpeakerSetId = UUID.fromString("23ff60ea-4050-442a-995b-f4dfef87166f");
    public static final UUID cheapSpeakerSetId = UUID.fromString("9f72bf30-a516-4269-b544-7450d3dc6dca");
    public static final UUID normalSpeakerSetId = UUID.fromString("df8d17fb-0216-4d8a-b575-9d2f77de8365");

    private Map<UUID, CarPart> carParts = new HashMap<>();

    HandCraftedCarPartRepositoryImpl(Map<UUID, CarPart> carParts) {
        this.carParts = carParts;
    }

    @Override
    public CarPart getById(UUID id) {
        CarPart carPart = carParts.get(id);
        if (carPart == null) {
            throw new CarPartNotFoundException();
        }

        return carPart;
    }

    @Override
    public Set<CarPart> getCompatiblePartsFor(
            CarTemplate carTemplate, TrimLevel trimLevel
    ) {
        Set<CarPart> compatibleCarParts = new HashSet<>();
        for (CarPart carPart : carParts.values()) {
            if (carPart.isCompatibleWith(carTemplate, trimLevel)) {
                compatibleCarParts.add(carPart);
            }
        }

        return compatibleCarParts;
    }
}
