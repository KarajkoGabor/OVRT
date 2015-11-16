package hu.kutya.car.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Sets;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.CarTemplateRepository;

public class HandCraftedCarTemplateRepositoryImpl implements CarTemplateRepository {
    public static final UUID lada2107UUID = UUID.fromString("a10ebb5b-dc0c-4650-8a03-8c9fae501e37");
    public static final UUID volvoXC90UUID = UUID.fromString("4d328f4e-f0d3-4e78-a628-60323fbc44ac");
    public static final UUID suzukiVitaraUUID = UUID.fromString("3d2533a9-dc43-4b9c-a360-ed463ad91ce9");

    private Map<UUID, CarTemplate> carTemplates = new HashMap<>();

    HandCraftedCarTemplateRepositoryImpl(Map<UUID, CarTemplate> carTemplates) {
        this.carTemplates = carTemplates;
    }

    @Override
    public Set<CarTemplate> getCarTemplates() {
        return Sets.newHashSet(carTemplates.values());
    }

    @Override
    public CarTemplate getById(UUID uuid) {
        return carTemplates.get(uuid);
    }
}
