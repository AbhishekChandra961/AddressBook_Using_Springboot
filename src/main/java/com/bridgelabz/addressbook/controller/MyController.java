package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.dto.ResponceDto;
import com.bridgelabz.addressbook.dto.Validation;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private AddressBookService addressBookService;
    @GetMapping("/{id}")
    public ResponceDto getDataByid(@PathVariable int id){
        AddressBookData addressBookData = addressBookService.getById(id);
        ResponceDto responceDto = new ResponceDto("Data is",addressBookData);
        return responceDto;
    }
    @PutMapping("/update/{id}")
    public ResponceDto update(@RequestBody AddressBookDto addressBookDto,@PathVariable int id){
        AddressBookData addressBookData =addressBookService.UpdateEmployee(id,addressBookDto);
        ResponceDto responceDto = new ResponceDto("Data is",addressBookData);
        return responceDto;
    }
    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable int id){
        addressBookService.delete(id);
        return "Deleted the data from the id"+id;
    }
    @GetMapping("/")
    public ResponceDto getAllData(){
        List<AddressBookData> data=addressBookService.getAllData();
        ResponceDto responceDto =new ResponceDto("The All Employees ",data);
        return responceDto;
    }
    @GetMapping("/token/{token}")
    public ResponseEntity<ResponceDto> getDataByToken(@PathVariable String token){
        AddressBookData addressBookData=addressBookService.getdataByToken(token);
        ResponceDto responceDto = new ResponceDto("Data for the token is ",addressBookData);
        return new ResponseEntity<>(responceDto, HttpStatus.CREATED);
    }
    @GetMapping("/DeletedData")
    public ResponceDto getDeletedData(){
        List<AddressBookData> data=addressBookService.getdeletedData();
        ResponceDto responceDto=new ResponceDto("The deleted data ",data);
        return responceDto;
    }
    @GetMapping("/originalData")
    public ResponceDto getoriginalData(){
        List<AddressBookData> data=addressBookService.getoriginalData();
        ResponceDto responceDto=new ResponceDto("The deleted data ",data);
        return responceDto;
    }

}
