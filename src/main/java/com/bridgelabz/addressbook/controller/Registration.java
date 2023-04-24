package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.Login;
import com.bridgelabz.addressbook.dto.Validation;
import com.bridgelabz.addressbook.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class Registration {
    @Autowired
    private RegistrationService regstationService;

    @PostMapping("/register")
    public String register(@RequestBody AddressBookDto addressBookDto){
        return regstationService.register(addressBookDto);
    }
    @PutMapping("/validate")
    public String validation(@RequestBody Validation validation ){

        return regstationService.validate(validation) ;

    }
    @PostMapping("/login")
    public String login (@RequestBody Login login){

        return regstationService.login(login) ;
    }

}
