package org.lifeline.service;
import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorServiceImpl implements DonorService {

    @Autowired
    private DonorRepository donorRepo;

    @Override
    public Donor saveDonor(Donor donor) {
        return donorRepo.save(donor);
    }

    //Validate user login
    public boolean validateLogin(String email, String password){
        Donor donor = donorRepo.findByEmail(email);
            if (donor.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
    }
}
