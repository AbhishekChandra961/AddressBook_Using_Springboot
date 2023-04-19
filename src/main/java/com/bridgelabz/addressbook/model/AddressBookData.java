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
    private String address;
    private String city;
    private String state;
    private String contactNumber;
    private int zip;
    private String token;
    public void updateData(AddressBookDto addressBookDto){
        this.name=addressBookDto.getName();
        this.address=addressBookDto.getAddress();
        this.city=addressBookDto.getCity();
        this.state=addressBookDto.getState();
        this.contactNumber=addressBookDto.getContactNumber();
        this.zip=addressBookDto.getZip();


    }
    public AddressBookData(AddressBookDto addressBookDto){

        this.updateData(addressBookDto);
    }

}
