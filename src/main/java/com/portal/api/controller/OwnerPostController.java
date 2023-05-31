package com.portal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.api.dto.OwnerPostDTO;
import com.portal.api.service.OwnerPostService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Proprietário")
@RestController
@RequestMapping("/owner")
public class OwnerPostController {
    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<?> postOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.postOwner(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
