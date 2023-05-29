package com.portal.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.CarPostDTO;
import com.portal.api.dto.GetCarListDTO;

@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public List<GetCarListDTO> getCarForSales() {
        return carPostStoreClient.carForSalesClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);

    }

    @Override
    public void removeCarForSale(String id) {

        carPostStoreClient.deleteCarForSaleClient(id);

    }

}
