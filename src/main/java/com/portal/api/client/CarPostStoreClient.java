package com.portal.api.client;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.OwnerPostDTO;

@Component
public class CarPostStoreClient {
    @Value("${STORE_SERVICE_URI}")
    private String storeCarURI;

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDTO> carForSalesClient() {
        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(storeCarURI + "/sales/cars",
                CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
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

}
