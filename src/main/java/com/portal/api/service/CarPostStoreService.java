package com.portal.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.GetCarListDTO;

@Service
public interface CarPostStoreService {

    List<GetCarListDTO> getCarForSales();

    void changeCarForSale(CarPostDTO carPost, String id);

    void removeCarForSale(String id);

    CarPostDTO getCarByID(String id);

}