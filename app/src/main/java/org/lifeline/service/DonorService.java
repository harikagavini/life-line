package org.lifeline.service;

import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;
import org.springframework.stereotype.Service;


@Service
public interface DonorService {

    public Donor saveDonor(Donor donor);
    public String validateLogin(AuthRequest authreq);
}
