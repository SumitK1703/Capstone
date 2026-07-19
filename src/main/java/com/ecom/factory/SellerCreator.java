package com.ecom.factory;

import com.ecom.models.User;
import com.ecom.models.Seller;

public class SellerCreator implements UserCreator {
    @Override
    public User createUser(String name, String email, String password) {
        return new Seller(name, email, password);
    }
}