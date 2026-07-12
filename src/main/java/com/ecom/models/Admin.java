package com.ecom.models;
import java.util.List;
public class Admin extends User{
    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
    public void deleteUser(int userId, List<User>users){
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserId() == userId){
                users.remove(i);
                System.out.println("User deleted.");
                return;
            }
        }
        System.out.println("User not found.");
    }
}