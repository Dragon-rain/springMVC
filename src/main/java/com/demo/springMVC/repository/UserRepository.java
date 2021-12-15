package com.demo.springMVC.repository;

import org.apache.ibatis.annotations.Param;

import com.demo.springMVC.dto.User;

public interface UserRepository {
	
	User userLogin(@Param("username") String username, @Param("password") String password);
	
	void userRegistration(@Param("user") User user,@Param("password") String password);
	
	void updateUser(@Param("user") User user);
	
	void updatePassword(@Param("user") User user,@Param("newPassword") String newPassword);
	
	void deleteUser(@Param("user") User user);

}
