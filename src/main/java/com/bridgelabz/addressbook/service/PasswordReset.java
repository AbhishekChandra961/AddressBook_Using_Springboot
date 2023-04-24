package com.bridgelabz.addressbook.service;

public interface PasswordReset {
    String forgotPassword(String email);
    String resetpassword(String email,String password);
}
