package com.backend.spring.dao;

import java.util.List;

import com.backend.spring.model.User;

public interface UserDao {

	void saveUser(User user);
    
    List<User> findAllUsers();
     
    void deleteUserById(int id);
    
    User findByNamePassword(String name,String password);
     
    User findById(int id);
     
    void updateUser(User user);
    
    void deleteAllUsers();
    
}
