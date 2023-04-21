package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends org.springframework.data.jpa.repository.JpaRepository<AddressBookData,Integer>{
    @Query(value = "Select id from AddressbookDB email = :email",nativeQuery = true)
    int findByEmail(String email);

    @Query(value = "select password from address_book_data where email= :email",nativeQuery = true)
    String getPassword(String email);
    @Query(value = "select email from address_book_data where email= :email",nativeQuery = true)
    String findEmail(String email);
}
