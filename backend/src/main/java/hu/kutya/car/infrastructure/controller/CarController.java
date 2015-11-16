package hu.kutya.car.infrastructure.controller;

import java.util.UUID;

import hu.kutya.car.CarFacade;
import hu.kutya.car.domain.Car;
import hu.kutya.car.infrastructure.dto.output.CarOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {
    @Autowired
    private CarFacade carFacade;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/{carId}/part/{partId}", method = RequestMethod.POST)
    public CarOutput buildCar(
            @PathVariable("carId") UUID carId,
            @PathVariable("partId") UUID partId
    ) {
        return carFacade.addPart(carId, partId);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/{carId}", method = RequestMethod.GET)
    public CarOutput getCar(
            @PathVariable("carId") UUID carId
    ) {
        return carFacade.getCarById(carId);
    }
}
