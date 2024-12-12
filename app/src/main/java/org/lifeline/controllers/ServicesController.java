package org.lifeline.controllers;

import org.lifeline.model.Events;
import org.lifeline.model.Services;
import org.lifeline.response.EventResponse;
import org.lifeline.response.ServicesResponse;
import org.lifeline.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeline/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @PostMapping
    public ServicesResponse saveServices(@RequestBody Services services) {
        servicesService.saveService(services);
        ServicesResponse serviceResponse = new ServicesResponse();
        serviceResponse.setMessage("Service created");
        serviceResponse.setSuccess(true);
        return serviceResponse;
    }

    @GetMapping
    public ResponseEntity<List<Services>> getAllEvents() {
        List<Services> services = servicesService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

}
