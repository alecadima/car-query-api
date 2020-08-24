package com.vmware.tanzu.car.query.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

/**
 * Entity that represent a Car in the domain
 *
 * @author Diego Pereira da Rocha
 * @since JDK 11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("car")
public class Car implements Serializable {

    @PrimaryKey
    private UUID id;
    @Size(min = 1, max = 64)
    @NotBlank
    @Column("nm_assembler")
    private String assembler;
    @Size(min = 1, max = 64)
    @NotBlank
    @Column("nm_model")
    private String model;
    @NotNull
    @Column("nr_manufacturing_year")
    private Integer manufacturingYear;
    @NotNull
    @Column("nr_model_year")
    private Integer modelYear;

}
