package com.ecom.factory;

import com.ecom.models.*;
/**
 * Factory class for creating different types of users.
 * Implements the Factory Design Pattern.
 */
public class UserFactory {
    private UserFactory() {
        // Prevent instantiation
    }
    public static User createUser(String type,
                                  String name,
                                  String email,
                                  String password) {

        switch (type.toLowerCase()) {

            case "admin":
                return new Admin(name, email, password);

            case "seller":
                return new Seller(name, email, password);

            case "customer":
                return new Customer(name, email, password);

            default:
                throw new IllegalArgumentException("Invalid user type.");
        }
    }
}