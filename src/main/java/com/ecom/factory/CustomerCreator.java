package com.ecom.factory;
import com.ecom.models.User;
import com.ecom.models.Customer;

public class CustomerCreator implements UserCreator {
    @Override
    public User createUser(String name, String email, String password) {
        return new Customer(name, email, password);
    }
}