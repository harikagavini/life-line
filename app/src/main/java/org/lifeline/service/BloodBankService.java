package org.lifeline.service;

import org.lifeline.model.BloodBank;
import org.springframework.stereotype.Service;

@Service
public interface BloodBankService {
    public BloodBank saveBloodBank(BloodBank bloodBank);
}
