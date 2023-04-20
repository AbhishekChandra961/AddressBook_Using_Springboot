package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer>{
    @Query(value = "Select otp from AddressbookDB email = :email",nativeQuery = true)
    long findByEmail(String email);
}
