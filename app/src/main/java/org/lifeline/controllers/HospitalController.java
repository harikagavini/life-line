package org.lifeline.controllers;

import org.lifeline.model.BloodBank;
import org.lifeline.model.HospitalLocation;
import org.lifeline.repository.BloodBankRepository;
import org.lifeline.repository.HospitalLocationRepository;
import org.lifeline.response.RegistrationResponse;
import org.lifeline.service.BloodBankService;
import org.lifeline.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifeline")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/register/hospital")
    public RegistrationResponse registerHospital(@RequestBody HospitalLocation hosp){
        hospitalService.saveHospital(hosp);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setMessage("Registration success");
        registrationResponse.setSuccess(true);
        return registrationResponse;
    }
}
