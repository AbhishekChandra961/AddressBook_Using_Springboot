package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.Login;
import com.bridgelabz.addressbook.dto.Validation;

public interface RegistrationService {
    String register(AddressBookDto addressBookDto);

    String validate(Validation validation);
    String login(Login login);

}
