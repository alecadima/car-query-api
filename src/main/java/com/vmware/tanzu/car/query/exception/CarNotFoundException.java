package com.vmware.tanzu.car.query.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that means when the Car is not find in the database
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {

}
