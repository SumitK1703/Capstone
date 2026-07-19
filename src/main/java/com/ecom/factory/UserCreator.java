package com.ecom.factory;

import com.ecom.models.User;

public interface UserCreator {
    User createUser(String name, String email, String password);
}