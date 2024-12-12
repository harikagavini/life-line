package org.lifeline.service;

import org.lifeline.model.Events;
import org.lifeline.model.Services;
import org.lifeline.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public Services saveService(Services services){
        if(services.getName() == null || services.getHospitalId() == null){
            throw new IllegalArgumentException("Service name and hospital ID should not be null");
        }
        return servicesRepository.save(services);
    }

    @Override
    public List<Services> getAllServices(){
        return servicesRepository.findAll();
    }

}
