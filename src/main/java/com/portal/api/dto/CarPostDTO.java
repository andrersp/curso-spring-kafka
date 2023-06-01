package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Schema(example = "GM")
    @NotBlank(message = "brand required")
    private String brand;

    @NotNull(message = "price not be null")
    private Double price;

    @NotBlank(message = "description required")
    @Size(min = 5)
    @Schema(example = "Description")
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
