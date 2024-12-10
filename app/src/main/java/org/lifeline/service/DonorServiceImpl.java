package org.lifeline.service;
import org.lifeline.model.AuthRequest;
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

    @Override
    public Donor saveDonor(Donor donor) {
        if(donor.getEmail() == null || donor.getPassword() == null) {
            throw new IllegalArgumentException("Email or password cannot be empty");
        }
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(donor.getEmail());
        authRequest.setPassword(donor.getPassword());
        authRepository.save(authRequest);

        return donorRepository.save(donor);
    }

    //Validate user login
    public boolean validateLogin(AuthRequest authReq){
        Donor donor = donorRepository.findByEmail(authReq.getEmail());
            if (donor.getPassword().equals(authReq.getPassword())) {
                return true;
            } else {
                return false;
            }
    }
}
