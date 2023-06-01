package com.portal.api.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.GetCarListDTO;
import com.portal.api.dto.OwnerPostDTO;

@Component
public class CarPostStoreClient {
    @Value("${STORE_SERVICE_URI}")
    private String storeCarURI;

    @Autowired
    RestTemplate restTemplate;

    public List<GetCarListDTO> carForSalesClient() {
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(storeCarURI + "/sales/cars",
                CarPostDTO[].class);

        List<GetCarListDTO> response = new ArrayList<>();

        for (CarPostDTO car : Objects.requireNonNull(responseEntity.getBody())) {

            GetCarListDTO carResponse = GetCarListDTO.builder()
                    .brand(car.getBrand())
                    .price(car.getPrice())
                    .model(car.getModel())
                    .id(car.getId())
                    .build();
            response.add(carResponse);

        }

        return response;
    }

    public void ownerPostClient(OwnerPostDTO newUser) {
        restTemplate.postForEntity(storeCarURI + "/user", newUser, OwnerPostDTO.class);
    }

    public void changeCarForSaleClient(CarPostDTO carPostDTO, String id) {
        restTemplate.put(storeCarURI + "/sales/cars/" + id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(storeCarURI + "/sales/cars/" + id);
    }

    public CarPostDTO getCarByID(String id) {

        ResponseEntity<CarPostDTO> responseEntity = restTemplate.getForEntity(storeCarURI + "/car/" + id,
                CarPostDTO.class);

        CarPostDTO car = Objects.requireNonNull(responseEntity.getBody());

        return car;

    }

}
