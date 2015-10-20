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

    private Map<UUID, CarTemplate> internalMap = new HashMap<>();

    HandCraftedCarTemplateRepositoryImpl() {
        TrimLevel lada2107Bad =
                TrimLevel.Restorer.restore(UUID.fromString("1989eff7-23a4-4c2a-95ad-e1a7b6f15f52"), "Bad", 500);
        TrimLevel lada2107Good =
                TrimLevel.Restorer.restore(UUID.fromString("bee6414b-4347-4818-951c-101c31bea99f"), "Good", 1000);
        CarTemplate lada2107 = CarTemplate.Restorer.restore(
                lada2107UUID,
                "http://rewrite.origos.hu/s/img/i/1204/20120426-lada-2105-21075.jpg",
                "2107",
                "Lada",
                Arrays.asList(lada2107Bad, lada2107Good)
        );

        internalMap.put(lada2107UUID, lada2107);
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
