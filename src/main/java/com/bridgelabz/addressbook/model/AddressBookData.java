package com.bridgelabz.addressbook.model;


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
}
