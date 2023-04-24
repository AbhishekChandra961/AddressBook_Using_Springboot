package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.Login;
import com.bridgelabz.addressbook.dto.Validation;
import com.bridgelabz.addressbook.exception.CustomException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressbookRepository;
import com.bridgelabz.addressbook.util.EmailService;
import com.bridgelabz.addressbook.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImp implements RegistrationService{
    @Autowired
    private AddressbookRepository addressbookRepository;
    @Autowired
    private JWTToken jwtToken;
    @Autowired
    private EmailService emailService;
    @Override
    public String register(AddressBookDto addressBookDto) {
        String email=addressBookDto.getEmail();
        System.out.println("the email is "+email);
        String mail=addressbookRepository.findEmail(email);
        System.out.println("the-"+mail+"the int mail is ");
        if(mail==null){
            AddressBookData addressBookData = new AddressBookData(addressBookDto);
            long genarateOtp = (long) ((Math.random() * 9999) % 8998) + 1001;
            addressBookData.setOtp(genarateOtp);
            addressbookRepository.save(addressBookData);
            emailService.sendEmail(addressBookData.getEmail(), "The data added successfully ", "hi  .." + addressBookData.getName() + "\n your data added succsessfully " + "\n your otp is  <- " + genarateOtp + " ->");
            return "otp genarated sucsussfully      - ";
        }
        return "Enter the unique Email id ";
    }
    @Override
    public String validate(Validation validation) {
        String email=validation.getEmail();
        int id=addressbookRepository.findByEmail(email);
        Optional<AddressBookData> data= Optional.ofNullable(addressbookRepository.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: " + id)));
        if(validation.getOtp()==data.get().getOtp()){
            String token=jwtToken.createToken(id);
            data.get().setVarifyOtp(true);
            data.get().setToken(token);
            addressbookRepository.save(data.get());
            return "validation done " + data.get().getEmail() ;
        }
        return "Invalid OTP";
    }
    @Override
    public String login(Login login) {
        String email =login.getEmail();
        String password=login.getPassword();
        String varifyPassword=addressbookRepository.getPassword(email);
        if (password.equals(varifyPassword)){
            return "login successfull..... ";
        }
        else{
            return" check the email and password";
       }
    }
}
