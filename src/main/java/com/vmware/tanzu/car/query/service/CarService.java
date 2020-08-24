package com.vmware.tanzu.car.query.service;

import com.vmware.tanzu.car.query.resource.CarResource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Service of Car
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Validated
public interface CarService {

    /**
     * Find a car by Id
     *
     * @param carId
     * @return
     */
    CarResource findById(@NotNull UUID carId);

    /**
     * Return all Cars
     *
     * @return
     */
    List<CarResource> findAll();

}