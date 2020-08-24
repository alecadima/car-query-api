package com.vmware.tanzu.car.query.api;

import com.vmware.tanzu.car.query.resource.CarResource;
import com.vmware.tanzu.car.query.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Car REST API
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@RestController
@RequestMapping("/api/cars")
public class CarApi {

    private CarService carService;

    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/{carId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCar(@PathVariable(value = "carId") UUID carId) {
        return ResponseEntity.ok(carService.findById(carId));
    }

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarResource>> getCars() {
        return ResponseEntity.ok(carService.findAll());
    }

}