package org.lifeline.service;
import org.lifeline.enums.RegistrationType;
import org.lifeline.jwt.JwtTokenGenerator;
import org.lifeline.model.AuthRequest;
import org.lifeline.model.BloodBank;
import org.lifeline.repository.AuthRepository;
import org.lifeline.repository.BloodBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodBankServiceImpl implements BloodBankService {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    @Override
    public BloodBank saveBloodBank(BloodBank bloodBank) {
        if(bloodBank.getEmail() == null || bloodBank.getPassword() == null || bloodBank.getBranchId() == null) {
            throw new IllegalArgumentException("Email or password or branch id cannot be empty");
        }
        if(authRepository.findByEmail(bloodBank.getEmail()) != null) {
            throw new IllegalStateException("The email is already registered in the system, please use another email");
        }

        BloodBank savedModel = bloodBankRepository.save(bloodBank);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(bloodBank.getEmail());
        authRequest.setPassword(bloodBank.getPassword());
        authRequest.setRegistrationType(RegistrationType.BLOOD_BANK);
        authRequest.setBranchId(bloodBank.getBranchId());
        authRepository.save(authRequest);

        return savedModel;
    }
}
