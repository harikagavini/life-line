package org.lifeline.controllers;


import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.lifeline.response.RegistrationResponse;
import org.lifeline.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeline")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @Autowired
    private DonorRepository donorRepo;

    @PostMapping("/register/donor")
    public RegistrationResponse registerDonor(@RequestBody Donor donor){
        donorService.saveDonor(donor);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setMessage("Registration success");
        registrationResponse.setSuccess(true);
        return registrationResponse;
    }
}
