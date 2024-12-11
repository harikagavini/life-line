package org.lifeline.service;

import org.lifeline.enums.RegistrationType;
import org.lifeline.jwt.JwtTokenGenerator;
import org.lifeline.model.AuthRequest;
import org.lifeline.model.HospitalLocation;
import org.lifeline.repository.AuthRepository;
import org.lifeline.repository.HospitalLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalLocationRepository hospRepo;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Override
    public HospitalLocation saveHospital(HospitalLocation hosp) {
        if(hosp.getEmail() == null || hosp.getPassword() == null || hosp.getHospitalId() == null) {
            throw new IllegalArgumentException("Email or password or hospital id cannot be empty");
        }
        if(authRepository.findByEmail(hosp.getEmail()) != null) {
            throw new IllegalStateException("The email is already registered in the system, please use another email");
        }

        HospitalLocation savedModel = hospRepo.save(hosp);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(hosp.getEmail());
        authRequest.setPassword(hosp.getPassword());
        authRequest.setRegistrationType(RegistrationType.HOSPITAL);
        authRepository.save(authRequest);

        return savedModel;
    }
}
