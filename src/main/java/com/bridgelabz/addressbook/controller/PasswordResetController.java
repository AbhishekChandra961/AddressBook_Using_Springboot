package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.Validation;
import com.bridgelabz.addressbook.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resetpassword")
public class PasswordResetController {
    @Autowired
    private com.bridgelabz.addressbook.service.PasswordReset passwordReset;
    @Autowired
    private RegistrationService regstationService;
    @PostMapping("forgot")
    public String forgetPassword(@RequestParam String email){
        return passwordReset.forgotPassword(email);
    }
    @PutMapping("/reset")
    public String resetPassword(@RequestParam String email,@RequestParam String password){
        return passwordReset.resetpassword(email,password);
    }
    @PutMapping("/varify")
    public String validation(@RequestBody Validation validation ){
        return regstationService.validate(validation) ;
    }
}
