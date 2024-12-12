package org.lifeline.service;
import org.lifeline.enums.RegistrationType;
import org.lifeline.jwt.JwtTokenGenerator;
import org.lifeline.model.AuthRequest;
import org.lifeline.model.BloodBank;
import org.lifeline.model.Donor;
import org.lifeline.repository.AuthRepository;
import org.lifeline.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Override
    public Donor saveDonor(Donor donor) {
        if(donor.getEmail() == null || donor.getPassword() == null) {
            throw new IllegalArgumentException("Email or password cannot be empty");
        }
        if(authRepository.findByEmail(donor.getEmail()) != null) {
            throw new IllegalStateException("The email is already registered in the system, please use another email");
        }

        Donor savedModel = donorRepository.save(donor);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(donor.getEmail());
        authRequest.setPassword(donor.getPassword());
        authRequest.setRegistrationType(RegistrationType.DONOR);
        authRequest.setDonorId(savedModel.getDonorId());
        authRepository.save(authRequest);

        return savedModel;
    }
}
