package org.lifeline.service;

import org.lifeline.model.Donor;

public interface DonorService {

    public Donor saveDonor(Donor donor);
    public boolean validateLogin(String email, String password);
}
