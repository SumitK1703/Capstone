package com.ecom.models;
import com.ecom.interfaces.Authenticatable;
public class User implements Authenticatable {
    private static final int INITIAL_USER_COUNT = 1;
    private static int currentUserCount = INITIAL_USER_COUNT;
    private final int userId;
    private String name;
    private String email;
    private String password;
    private boolean loginStatus;

    public User(String name, String email, String password) {
        if (name==null || email==null || password==null){
            throw new IllegalArgumentException("Username or email or password is null");
        }
        this.name = name;
        this.email = email;
        this.password = password;
        this.userId = currentUserCount++;
        this.loginStatus = false;
    }
    public void register() {
        System.out.println("Registration successful.");
        System.out.println("User ID : " + userId);
    }
    public int getUserId() {
        return userId;
    }
    public boolean login(String email, String password) {
        if(this.email.equals(email) && this.password.equals(password)) {
            loginStatus = true;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean logout() {
        loginStatus = false;
//        System.out.println("Logged out successfully.");
        return true;
    }

    void deleteAccount() {
        System.out.println("Account deletion requested.");
    }
    public boolean updateProfile(String name, String email, String password){

        this.name = name;
        this.email = email;
        this.password = password;
//      System.out.println("Profile updated successfully.");
        return true;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public boolean isLoginStatus(){
        return loginStatus;
    }

}