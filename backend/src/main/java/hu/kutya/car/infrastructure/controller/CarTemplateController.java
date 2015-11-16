package hu.kutya.car.infrastructure.controller;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.validation.Valid;

import hu.kutya.car.CarFacade;
import hu.kutya.car.domain.CarPart;
import hu.kutya.car.infrastructure.dto.output.CarOutput;
import hu.kutya.car.infrastructure.dto.output.CarTemplateOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/car_templates", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarTemplateController {
    @Autowired
    private CarFacade carFacade;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/{carTemplateId}", method = RequestMethod.GET)
    public CarTemplateOutput getCarTemplate(@Valid @PathVariable("carTemplateId") UUID carTemplateId) {
        return carFacade.getCarTemplate(carTemplateId);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CarTemplateOutput> getCarTemplates() {
        return carFacade.getCarTemplates();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = "/{carTemplateId}/trim_levels/{trimLevelId}/build", method = RequestMethod.POST)
    public CarOutput buildCar(
            @PathVariable("carTemplateId") UUID carTemplateId,
            @PathVariable("trimLevelId") UUID trimLevelId
    ) {
        return carFacade.buildCar(carTemplateId, trimLevelId);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/{carTemplateId}/trim_levels/{trimLevelId}/compatible_parts", method = RequestMethod.GET)
    public Set<CarPart> getCompatibleCarParts(
            @PathVariable("carTemplateId") UUID carTemplateId,
            @PathVariable("trimLevelId") UUID trimLevelId
    ) {
        return carFacade.getCompatibleCarParts(carTemplateId, trimLevelId);
    }
}
