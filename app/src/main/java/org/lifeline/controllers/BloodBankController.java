package org.lifeline.controllers;

import org.lifeline.model.BloodBank;
import org.lifeline.repository.BloodBankRepository;
import org.lifeline.response.RegistrationResponse;
import org.lifeline.service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifeline")
public class BloodBankController {
    @Autowired
    private BloodBankService bloodBankService;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @PostMapping("/register/bloodbank")
    public RegistrationResponse registerBloodBank(@RequestBody BloodBank bloodBank){
        bloodBankService.saveBloodBank(bloodBank);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setMessage("Registration success");
        registrationResponse.setSuccess(true);
        return registrationResponse;
    }
}
