package hu.kutya.car.infrastructure.repository;

import java.util.*;

import com.google.common.collect.Sets;
import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.CarTemplateRepository;
import hu.kutya.car.domain.TrimLevel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("handCrafted")
//// TODO: 2015.10.18. implement these methods using hard coded data
public class HandCraftedCarTemplateRepositoryImpl implements CarTemplateRepository {
    public static final UUID lada2107UUID = UUID.fromString("a10ebb5b-dc0c-4650-8a03-8c9fae501e37");
    public static final UUID volvoXC90UUID = UUID.fromString("4d328f4e-f0d3-4e78-a628-60323fbc44ac");
    public static final UUID suzukiVitaraUUID = UUID.fromString("3d2533a9-dc43-4b9c-a360-ed463ad91ce9");

    private Map<UUID, CarTemplate> internalMap = new HashMap<>();

    HandCraftedCarTemplateRepositoryImpl() {
        TrimLevel street =
                TrimLevel.Restorer.restore(UUID.fromString("1989eff7-23a4-4c2a-95ad-e1a7b6f15f52"), "Street", 500);
        TrimLevel offRoad =
                TrimLevel.Restorer.restore(UUID.fromString("bee6414b-4347-4818-951c-101c31bea99f"), "Off Road", 1000);
        TrimLevel racing =
                TrimLevel.Restorer.restore(UUID.fromString("4f284119-eb7d-4aeb-b52a-4bfd3f796919"), "Racing", 1000);
        TrimLevel eco =
                TrimLevel.Restorer.restore(UUID.fromString("f44422ba-ad37-4014-9555-c1f4a731b976"), "Eco", 1000);
        CarTemplate lada2107 = CarTemplate.Restorer.restore(
                lada2107UUID,
                "http://rewrite.origos.hu/s/img/i/1204/20120426-lada-2105-21075.jpg",
                "2107",
                "Lada",
                Arrays.asList(street, offRoad, racing, eco)
        );
        CarTemplate volvoXC90 = CarTemplate.Restorer.restore(
                volvoXC90UUID,
                "http://assets.volvocars.com/hu/~/media/images/galleries/new-cars/new-xc90/editions/gallery-module-1/gallery1_1_vcc08316.jpg",
                "XC90",
                "Volvo",
                Arrays.asList(street, offRoad, racing, eco)
        );
        CarTemplate suzukiVitara = CarTemplate.Restorer.restore(
                suzukiVitaraUUID,
                "http://autopult.hu/galeria/1504teszt/vitarad/suzuki_vitara_diesel_allgrip_a5_medium.jpg",
                "Vitara",
                "Suzuki",
                Arrays.asList(street, offRoad, racing, eco)
        );

        internalMap.put(lada2107UUID, lada2107);
        internalMap.put(volvoXC90UUID, volvoXC90);
        internalMap.put(suzukiVitaraUUID, suzukiVitara);
    }

    @Override
    public Set<CarTemplate> getCarTemplates() {
        return Sets.newHashSet(internalMap.values());
    }

    @Override
    public CarTemplate getById(UUID uuid) {
        return internalMap.get(uuid);
    }
}
