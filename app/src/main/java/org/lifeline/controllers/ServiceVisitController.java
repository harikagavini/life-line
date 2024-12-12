package org.lifeline.controllers;

import org.lifeline.model.ServiceVisit;
import org.lifeline.service.ServiceVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeline/serviceVisit")
public class ServiceVisitController {

    @Autowired
    private ServiceVisitService serviceVisitService;

    @GetMapping("/{donorId}")
    public List<ServiceVisit> getServiceVisitsByDonorId(@PathVariable Long donorId) {
        return serviceVisitService.getServiceVisitsByDonorId(donorId);
    }

}
