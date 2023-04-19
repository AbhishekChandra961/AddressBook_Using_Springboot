package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.ResponceDto;
import com.bridgelabz.addressbook.model.AddressBookData;

import java.util.List;

public interface AddressBookService {
    ResponceDto addData(AddressBookDto addressBookDto);
    AddressBookData getById(int id);


    AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto);

    void delete(int id);

    List<AddressBookData> getAllData();

    AddressBookData getdataByToken(String token);
    List<AddressBookData> getdeletedData();

    List<AddressBookData> getoriginalData();
}
