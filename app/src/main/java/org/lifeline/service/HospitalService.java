package org.lifeline.service;

import org.lifeline.model.HospitalLocation;
import org.springframework.stereotype.Service;

@Service
public interface HospitalService {
    public HospitalLocation saveHospital(HospitalLocation hospitalLocation);
}
