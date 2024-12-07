package org.lifeline.service;

import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;

public interface DonorService {

    public Donor saveDonor(Donor donor);
    public boolean validateLogin(AuthRequest authreq);
}
