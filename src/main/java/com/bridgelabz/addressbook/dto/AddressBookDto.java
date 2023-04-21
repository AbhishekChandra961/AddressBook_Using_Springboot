package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDto {


    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "The Name is notEmpty")
    private String name;
    @NotNull(message = "The email ")
    private String email;
    private String password;
    private String token;
    private long otp;
    private boolean varifyOtp;


}
