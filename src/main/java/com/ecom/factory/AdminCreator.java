package com.ecom.factory;

import com.ecom.models.User;
import com.ecom.models.Admin;

public class AdminCreator implements UserCreator {
    @Override
    public User createUser(String name, String email, String password) {
        return new Admin(name, email, password);
    }
}