package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressbookRepository extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "select id from addressbookspringboot.address_book_data where email = :email",nativeQuery = true)
    int findByEmail(String email);

    @Query(value = "select password from addressbookspringboot.address_book_data where email = :email",nativeQuery = true)
    String getPassword(String email);
    @Query(value = "select email from addressbookspringboot.address_book_data where email= :email",nativeQuery = true)
    String findEmail(String email);

}
