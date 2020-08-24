package com.vmware.tanzu.car.query.service;

import com.vmware.tanzu.car.query.domain.Car;
import com.vmware.tanzu.car.query.exception.CarNotFoundException;
import com.vmware.tanzu.car.query.repository.CarRepository;
import com.vmware.tanzu.car.query.resource.CarResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementation of Car Service
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    /**
     * Convert entity to Mode (Domain->Resource)
     */
    private final Function<Car, CarResource> mapEntityToResource = car ->
            CarResource.builder()
                    .id(car.getId())
                    .assembler(car.getAssembler())
                    .model(car.getModel())
                    .manufacturingYear(car.getManufacturingYear())
                    .modelYear(car.getModelYear())
                    .build();

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * @param carId ID Car
     * @see CarService#findById(UUID)
     */
    @Override
    @Transactional(readOnly = true)
    public CarResource findById(UUID carId) {
        checkCarExists(carId);
        return mapEntityToResource.apply(carRepository.findById(carId).get());
    }

    /**
     * @see CarService#findAll()
     */
    @Override
    @Transactional(readOnly = true)
    public List<CarResource> findAll() {
        return StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .map(mapEntityToResource).collect(Collectors.toList());
    }

    /**
     * Check if the Car with id provided exist in the database
     *
     * @param idCar Id car
     */
    private void checkCarExists(UUID idCar) {
        boolean exists = carRepository.existsById(idCar);
        if (!exists) {
            throw new CarNotFoundException();
        }
    }

}