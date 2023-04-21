package com.bridgelabz.addressbook.model;


import com.bridgelabz.addressbook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookData {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private String token;
    private long otp;
    private boolean varifyOtp;


    public void updateData(AddressBookDto addressBookDto){
        this.email= addressBookDto.getEmail();
        this.name= addressBookDto.getName();
        this.password=addressBookDto.getPassword();
    }

    public AddressBookData(AddressBookDto addressBookDto){
        this.updateData(addressBookDto);
    }
}