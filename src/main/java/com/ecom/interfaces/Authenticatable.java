package com.ecom.interfaces;

public interface Authenticatable {

    void login(String email, String password);

    void logout();
}