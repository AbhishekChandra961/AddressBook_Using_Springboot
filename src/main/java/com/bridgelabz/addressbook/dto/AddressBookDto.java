package com.bridgelabz.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDto {
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$",message = "The Name is notEmpty")
    private String name;
    @NotEmpty(message = "The address is not empty")

    private String address;
    @NotEmpty(message = "The city is not empty")

    private String city;
    @NotEmpty(message = "The state is not empty")

    private String state;
    @NotEmpty(message = "The Phone number is not empty")
    @Pattern(regexp = "^[0-9]{2}[0-9]{10}$")
    private String contactNumber;
    private int zip;
}
