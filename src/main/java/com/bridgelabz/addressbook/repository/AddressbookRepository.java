package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer>{
}
