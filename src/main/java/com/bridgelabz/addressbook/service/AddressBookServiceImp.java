package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.ResponceDto;
import com.bridgelabz.addressbook.exception.CustomException;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressbookRepository;
import com.bridgelabz.addressbook.util.JWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImp implements AddressBookService{
    List<AddressBookData> list=new ArrayList<>();
    @Autowired
    private AddressbookRepository addressbookRepository;
    @Autowired
    private JWTToken jwtToken;
    @Override
    public ResponceDto addData(AddressBookDto addressBookDto) {
        AddressBookData addressBookData=new AddressBookData(addressBookDto);
        addressbookRepository.save(addressBookData);
        String token=jwtToken.createToken(addressBookData.getId());
        list.add(addressBookData);
        ResponceDto responceDto=new ResponceDto(token,addressBookData);
        return responceDto;
    }

    @Override
    public AddressBookData getById(int id) {
        return addressbookRepository.findById(id).orElseThrow(() -> new CustomException(" Employee Not found .. wih id: "+ id));
    }

    @Override
    public AddressBookData UpdateEmployee(int id, AddressBookDto addressBookDto) {
        AddressBookData addressBookData =this.getById(id);
        addressBookData.updateData(addressBookDto);
        return addressbookRepository.save(addressBookData);
    }

    @Override
    public void delete(int id) {
        AddressBookData addressBookData =this.getById(id);
        addressbookRepository.delete(addressBookData);
    }

    @Override
    public List<AddressBookData> getAllData() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressBookData getdataByToken(String token) {
        int id= jwtToken.decodeToken(token);
        return addressbookRepository.findById(id).orElseThrow(() -> new CustomException("Employee Not found :- "+id));
    }

    @Override
    public List<AddressBookData> getdeletedData() {
        return deletedList;
    }

    @Override
    public List<AddressBookData> getoriginalData() {
        return updatedList;
    }


}
