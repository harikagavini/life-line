package org.lifeline.service;

import org.lifeline.model.ServiceVisit;

import java.util.List;

public interface ServiceVisitService {
    public List<ServiceVisit> getServiceVisitsByDonorId(Long donorId);
}
