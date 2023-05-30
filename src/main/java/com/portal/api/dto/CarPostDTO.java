package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CarPostDTO {

    private Long id;

    @NotBlank(message = "model required")
    private String model;

    @NotBlank(message = "brand required")
    private String brand;

    @NotNull(message = "price not be null")
    private Double price;

    @NotBlank(message = "description required")
    @Min(value = 10, message = "min lenght")
    private String description;

    private String engineVersion;

    private String city;

    private String createdDate;

    @Min(value = 1)
    @NotNull(message = "required")
    private Long ownerId;

    private String ownerName;

    private String ownerType;

    private String contact;

}
