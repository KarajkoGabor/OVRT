package hu.kutya.car.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import hu.kutya.car.domain.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DbInitializer {
    private HandCraftedCarTemplateRepositoryImpl carTemplateRepository;

    private HandCraftedCarPartRepositoryImpl carPartRepository;

    DbInitializer() {
        Map<UUID, CarPart> carParts = new HashMap<>();

        Engine racingEngine = new Engine(HandCraftedCarPartRepositoryImpl.racingEngineId, 1800, 200);
        Engine ecoEngine = new Engine(HandCraftedCarPartRepositoryImpl.ecoEngineId, 900, 60);
        Engine streetEngine = new Engine(HandCraftedCarPartRepositoryImpl.streetEngineId, 750, 85);
        Engine offRoadEngine = new Engine(HandCraftedCarPartRepositoryImpl.offRoadEngineId, 1200, 115);

        Transmission goodTransmission = new Transmission(HandCraftedCarPartRepositoryImpl.goodTransmissionId, 200, 5);
        Transmission badTransmission = new Transmission(HandCraftedCarPartRepositoryImpl.badTransmissionId, 130, 4);
        Transmission luxuryTransmission =
                new Transmission(HandCraftedCarPartRepositoryImpl.luxuryTransmissionId, 630, 6);

        Upholstery normalUpholstery = new Upholstery(HandCraftedCarPartRepositoryImpl.normalUpholsteryId, 80);
        Upholstery cheapUpholstery = new Upholstery(HandCraftedCarPartRepositoryImpl.cheapUpholsteryId, 55);
        Upholstery luxuryUpholstery = new Upholstery(HandCraftedCarPartRepositoryImpl.luxuryUpholsteryId, 130);

        Radio romanianRadio = new Radio(HandCraftedCarPartRepositoryImpl.romanianRadioId, 5);
        Radio polishRadio = new Radio(HandCraftedCarPartRepositoryImpl.polishRadioId, 12);
        Radio luxuryRadio = new Radio(HandCraftedCarPartRepositoryImpl.luxuryRadioId, 45);
        Radio goodRadio = new Radio(HandCraftedCarPartRepositoryImpl.goodRadioId, 29);

        GPS normalGPS = new GPS(HandCraftedCarPartRepositoryImpl.normalGPSId, 12);
        GPS luxuryGPS = new GPS(HandCraftedCarPartRepositoryImpl.luxuryGPSId, 35);

        SpeakerSet luxurySpeakerSet = new SpeakerSet(HandCraftedCarPartRepositoryImpl.luxurySpeakerSetId, 120);
        SpeakerSet cheapSpeakerSet = new SpeakerSet(HandCraftedCarPartRepositoryImpl.cheapSpeakerSetId, 45);
        SpeakerSet normalSpeakerSet = new SpeakerSet(HandCraftedCarPartRepositoryImpl.normalSpeakerSetId, 99);

        TrimLevel streetTrimLevel =
                new TrimLevel.Builder(600, "Street", streetEngine, goodTransmission, cheapUpholstery)
                        .withAccessory(polishRadio)
                        .withAccessory(cheapSpeakerSet)
                        .build();

        TrimLevel offRoadTrimLevel =
                new TrimLevel.Builder(1100, "Off Road", offRoadEngine, goodTransmission, normalUpholstery)
                        .withAccessory(goodRadio)
                        .withAccessory(normalGPS)
                        .withAccessory(normalSpeakerSet)
                        .build();

        TrimLevel racingTrimLevel =
                new TrimLevel.Builder(1850, "Racing", racingEngine, luxuryTransmission, luxuryUpholstery)
                        .withAccessory(luxuryRadio)
                        .withAccessory(luxuryGPS)
                        .withAccessory(luxurySpeakerSet)
                        .build();

        TrimLevel ecoTrimLevel = new TrimLevel.Builder(600, "Eco", ecoEngine, badTransmission, cheapUpholstery)
                .withAccessory(romanianRadio)
                .withAccessory(normalGPS)
                .withAccessory(cheapSpeakerSet)
                .build();

        CarTemplate lada2107CarTemplate = new CarTemplate.Builder(
                HandCraftedCarTemplateRepositoryImpl.lada2107UUID,
                "http://rewrite.origos.hu/s/img/i/1204/20120426-lada-2105-21075.jpg",
                "2107",
                "Lada"
        ).withTrimLevel(streetTrimLevel).withTrimLevel(offRoadTrimLevel).build();

        CarTemplate volvoXC90CarTemplate = new CarTemplate.Builder(
                HandCraftedCarTemplateRepositoryImpl.volvoXC90UUID,
                "http://assets.volvocars.com/hu/~/media/images/galleries/new-cars/new-xc90/editions/gallery-module-1/gallery1_1_vcc08316.jpg",
                "XC90",
                "Volvo"
        ).withTrimLevel(streetTrimLevel).withTrimLevel(racingTrimLevel).withTrimLevel(offRoadTrimLevel).build();

        CarTemplate suzukiVitaraCarTemplate = new CarTemplate.Builder(
                HandCraftedCarTemplateRepositoryImpl.suzukiVitaraUUID,
                "http://autopult.hu/galeria/1504teszt/vitarad/suzuki_vitara_diesel_allgrip_a5_medium.jpg",
                "Vitara",
                "Suzuki"
        ).withTrimLevel(streetTrimLevel)
                .withTrimLevel(offRoadTrimLevel)
                .withTrimLevel(ecoTrimLevel)
                .withTrimLevel(racingTrimLevel)
                .build();

        Map<UUID, CarTemplate> carTemplates = new HashMap<>();
        carTemplates.put(lada2107CarTemplate.getId(), lada2107CarTemplate);
        carTemplates.put(volvoXC90CarTemplate.getId(), volvoXC90CarTemplate);
        carTemplates.put(suzukiVitaraCarTemplate.getId(), suzukiVitaraCarTemplate);

        carTemplateRepository = new HandCraftedCarTemplateRepositoryImpl(carTemplates);

        racingEngine.setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel);

        streetEngine.setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(lada2107CarTemplate, streetTrimLevel);

        offRoadEngine.setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel);

        ecoEngine.setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel);

        goodTransmission.setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel);

        badTransmission.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel);

        luxuryTransmission.setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        cheapUpholstery.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        normalUpholstery.setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        luxuryUpholstery.setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        romanianRadio.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel);

        polishRadio.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel);

        goodRadio.setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        luxuryRadio.setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        normalGPS.setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        luxuryGPS.setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        cheapSpeakerSet.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(lada2107CarTemplate, offRoadTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel);

        normalSpeakerSet.setCompatibility(lada2107CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, streetTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, offRoadTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, ecoTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        luxurySpeakerSet.setCompatibility(volvoXC90CarTemplate, streetTrimLevel)
                .setCompatibility(volvoXC90CarTemplate, racingTrimLevel)
                .setCompatibility(suzukiVitaraCarTemplate, racingTrimLevel);

        carParts.put(racingEngine.getId(), racingEngine);
        carParts.put(ecoEngine.getId(), ecoEngine);
        carParts.put(streetEngine.getId(), streetEngine);
        carParts.put(offRoadEngine.getId(), offRoadEngine);
        carParts.put(goodTransmission.getId(), goodTransmission);
        carParts.put(badTransmission.getId(), badTransmission);
        carParts.put(luxuryTransmission.getId(), luxuryTransmission);
        carParts.put(normalUpholstery.getId(), normalUpholstery);
        carParts.put(cheapUpholstery.getId(), cheapUpholstery);
        carParts.put(luxuryUpholstery.getId(), luxuryUpholstery);
        carParts.put(romanianRadio.getId(), romanianRadio);
        carParts.put(polishRadio.getId(), polishRadio);
        carParts.put(luxuryRadio.getId(), luxuryRadio);
        carParts.put(goodRadio.getId(), goodRadio);
        carParts.put(normalGPS.getId(), normalGPS);
        carParts.put(luxuryGPS.getId(), luxuryGPS);
        carParts.put(luxurySpeakerSet.getId(), luxurySpeakerSet);
        carParts.put(cheapSpeakerSet.getId(), cheapSpeakerSet);
        carParts.put(normalSpeakerSet.getId(), normalSpeakerSet);

        carPartRepository = new HandCraftedCarPartRepositoryImpl(carParts);
    }

    @Bean
    HandCraftedCarPartRepositoryImpl handCraftedCarPartRepository() {
        return carPartRepository;
    }

    @Bean
    HandCraftedCarTemplateRepositoryImpl handCraftedCarTemplateRepository() {
        return carTemplateRepository;
    }
}
