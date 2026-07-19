package com.ecom.interfaces;

public interface Authenticatable {

    boolean login(String email, String password);

    boolean logout();
}