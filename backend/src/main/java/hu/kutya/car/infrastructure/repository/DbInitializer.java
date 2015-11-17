package hu.kutya.car.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import hu.kutya.car.domain.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DbInitializer {
    public static final UUID streetTrimLevelId = UUID.fromString("7ec53bc7-af32-46c9-a9dc-7203561cd8e7");
    public static final UUID offRoadTrimLevelId = UUID.fromString("cd5d5dac-ff58-4257-99fc-e37f078c093f");
    public static final UUID racingTrimLevelId = UUID.fromString("2684a6ec-99c8-4b4d-b78d-103e2a69a244");
    public static final UUID ecoTrimLevelId = UUID.fromString("cedfe197-4478-4a35-b1f5-98dfd864f5e6");


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

        //igy kell imageUrl-t allitani:
        luxurySpeakerSet.setImageUrl(
                "http://img06.deviantart.net/6d9c/i/2014/136/0/b/twinkie_doge_by_rayleeman-d7inngz.jpg");
        cheapSpeakerSet.setName("El Cheapo Speaker Set");
        normalSpeakerSet.setName("El Normalo Speaker Set");

        racingEngine.setImageUrl("http://www.etcracingprograms.com/images/GM_UAW/gm_engine.jpg");
        racingEngine.setName("Cunt Destroyer Engine");

        ecoEngine.setImageUrl("http://www.kursy-jazdy.com/wp-content/uploads/2015/08/zasady-ekonomicznej-jazdy.jpg");
        ecoEngine.setName("Save the forests Engine");

        streetEngine.setImageUrl("http://www.sonnysracingengines.com/images/cms/97c7bfad-4994-eda9.jpg");
        streetEngine.setName("Fast As Hell");

        offRoadEngine.setImageUrl("http://image.fourwheeler.com/f/24943766+w660+re0/131_0910_18_z%2Btruck_crate_engine_guide%2Bkatech_performance.jpg");
        offRoadEngine.setName("Dirty");

        goodTransmission.setImageUrl("http://blog.autointhebox.com/wp-content/uploads/2015/04/What-type-of-transmission-is-the-best.jpg");
        goodTransmission.setName("Best transmission");

        badTransmission.setImageUrl("http://www.huebberally.com/wp-content/gallery/01_02_2007/old_transmission.jpg");
        badTransmission.setName("Hope and shift");

        luxuryTransmission.setImageUrl("http://www.bbb.org/globalassets/local-bbbs/detroit-mi-80/media/programs/transmission1.jpg");
        luxuryTransmission.setName("PureGold");

        normalUpholstery.setImageUrl("http://carswave.com/wp-content/uploads/2015/09/Reupholster-car-seats.jpg");
        normalUpholstery.setName("Causal as fuck");

        cheapUpholstery.setImageUrl("http://vpstestbringatrailercom.c.presscdn.com/wp-content/uploads/2015/06/1974-Alfa-Romeo-2000-GTV-Interior.jpg");
        cheapUpholstery.setName("Still sitable");

        luxuryUpholstery.setImageUrl("https://s-media-cache-ak0.pinimg.com/originals/a7/95/8f/a7958f7b38f34f1fb35d3d0644a763c9.jpg");
        luxuryUpholstery.setName("Assgasm");

        romanianRadio.setImageUrl("http://www.brucesallan.com/wp-content/uploads/2013/03/Becker-Car-Stereo.jpg");
        romanianRadio.setName("Cat costa?");

        polishRadio.setImageUrl("http://www.dabonwheels.co.uk/uploaded_images/KDC-DAB4551U.jpg");
        polishRadio.setName("Polak Voice");

        luxuryRadio.setImageUrl("http://cdn.androidcommunity.com/wp-content/uploads/2012/03/DSC_0128b2-860x561.jpg");
        luxuryRadio.setName("Eargasm");

        goodRadio.setImageUrl("http://shakefire.com/sites/default/files/uploads/MEX-BT5700_front%5B1%5D.jpg");
        goodRadio.setName("Hear me roar");

        normalGPS.setImageUrl("http://www.kisaetr.hu/sites/default/files/pictures/gps-find-your-business-image.jpg");
        normalGPS.setName("TrackOn");

        luxuryGPS.setImageUrl("http://www.gpsgadgets.net/wp-content/uploads/sites/3/2007/05/expensivegps-2.jpg");
        luxuryGPS.setName("NavigateByItself");


        TrimLevel streetTrimLevel =
                new TrimLevel.Builder(streetTrimLevelId, 600, "Street", streetEngine, goodTransmission, cheapUpholstery)
                        .withAccessory(polishRadio)
                        .withAccessory(cheapSpeakerSet)
                        .build();

        TrimLevel offRoadTrimLevel =
                new TrimLevel.Builder(
                        offRoadTrimLevelId,
                        1100,
                        "Off Road",
                        offRoadEngine,
                        goodTransmission,
                        normalUpholstery
                )
                        .withAccessory(goodRadio)
                        .withAccessory(normalGPS)
                        .withAccessory(normalSpeakerSet)
                        .build();

        TrimLevel racingTrimLevel =
                new TrimLevel.Builder(
                        racingTrimLevelId,
                        1850,
                        "Racing",
                        racingEngine,
                        luxuryTransmission,
                        luxuryUpholstery
                )
                        .withAccessory(luxuryRadio)
                        .withAccessory(luxuryGPS)
                        .withAccessory(luxurySpeakerSet)
                        .build();

        TrimLevel ecoTrimLevel =
                new TrimLevel.Builder(ecoTrimLevelId, 600, "Eco", ecoEngine, badTransmission, cheapUpholstery)
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
