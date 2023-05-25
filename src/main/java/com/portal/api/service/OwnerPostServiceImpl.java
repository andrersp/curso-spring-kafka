package com.portal.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.api.client.CarPostStoreClient;
import com.portal.api.dto.OwnerPostDTO;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    @Override
    public void postOwner(OwnerPostDTO newUser) {

        carPostStoreClient.ownerPostClient(newUser);

    }

}
