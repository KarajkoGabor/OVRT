package hu.kutya.car.infrastructure.repository;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import hu.kutya.car.domain.CarTemplate;
import hu.kutya.car.domain.CarTemplateRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("handCrafted")
//// TODO: 2015.10.18. implement these methods using hard coded data 
public class HandCraftedCarTemplateRepositoryImpl implements CarTemplateRepository {
    @Override
    public Set<CarTemplate> getCarTemplates() {
        return Collections.emptySet();
    }

    @Override
    public CarTemplate getById(UUID uuid) {
        return null;
    }
}
