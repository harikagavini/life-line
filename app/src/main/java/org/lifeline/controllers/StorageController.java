package org.lifeline.controllers;

import org.lifeline.model.Order;
import org.lifeline.model.Storage;
import org.lifeline.repository.StorageRepository;
import org.lifeline.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeline/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    public ResponseEntity<List<Storage>> getAllStorages() {
        List<Storage> orders = storageService.getAllStorages();
        return ResponseEntity.ok(orders);
    }
}


