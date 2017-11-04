package com.backend.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.spring.dao.UserDao;
import com.backend.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao dao;
	
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		dao.saveUser(user);
	}

	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return dao.findAllUsers();
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		dao.deleteUserById(id);
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		dao.deleteAllUsers();
	}

	public User findByNamePassword(String name, String password) {
		// TODO Auto-generated method stub
		return dao.findByNamePassword(name, password);
	}

}
