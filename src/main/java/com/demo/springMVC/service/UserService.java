package com.demo.springMVC.service;

import com.demo.springMVC.dto.User;

public interface UserService {
	
	User userLogin(String username, String password);
	
	void userRegistration(User newUser, String password);
	
	void updateUser(User user);
	
	void updatePassword(User user, String newPassword);
	
	void deleteUser(User user);

}
