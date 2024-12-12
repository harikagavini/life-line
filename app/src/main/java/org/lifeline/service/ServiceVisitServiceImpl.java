package org.lifeline.service;

import org.lifeline.model.ServiceVisit;
import org.lifeline.repository.ServiceVisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVisitServiceImpl implements ServiceVisitService{

    @Autowired
    private ServiceVisitRepository serviceVisitRepository;

    @Override
    public List<ServiceVisit> getServiceVisitsByDonorId(Long donorId) {
        return serviceVisitRepository.findByDonorId(donorId);

    }
}
