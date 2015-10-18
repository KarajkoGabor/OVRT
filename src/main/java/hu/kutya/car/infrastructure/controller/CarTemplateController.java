package hu.kutya.car.infrastructure.controller;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import hu.kutya.car.CarFacade;
import hu.kutya.car.infrastructure.dto.output.CarOutput;
import hu.kutya.car.infrastructure.dto.output.CarTemplateOutput;
import hu.kutya.car.infrastructure.dto.output.TrimLevelOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/car_templates", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarTemplateController {

    @Autowired
    private CarFacade carFacade;

    @RequestMapping(value = "/{carTemplateId}", method = RequestMethod.GET)
    public CarTemplateOutput getCarTemplate(@Valid @PathVariable("carTemplateId") UUID carTemplateId) {
        return carFacade.getCarTemplate(carTemplateId);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CarTemplateOutput> getCarTemplates() {
        return carFacade.getCarTemplates();
    }

    @RequestMapping(value = "/{carTemplateId}/trim_levels", method = RequestMethod.GET)
    public List<TrimLevelOutput> getTrimLevelsOfCarTemplate(@Valid @PathVariable("carTemplateId") UUID carTemplateId) {
        return carFacade.getTrimLevelsOfCarTemplate(carTemplateId);
    }

    @RequestMapping(value = "/{carTemplateId}/trim_levels/{trimLevelId}/build", method = RequestMethod.POST)
    public CarOutput buildCar(
            @Valid @PathVariable("carTemplateId") UUID carTemplateId,
            @Valid @PathVariable("trimLevelId") UUID trimLevelId
    ) {
        return carFacade.buildCar(carTemplateId, trimLevelId);
    }
}
