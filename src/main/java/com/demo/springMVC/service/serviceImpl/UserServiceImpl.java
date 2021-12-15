package com.demo.springMVC.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springMVC.dto.User;
import com.demo.springMVC.dto.UserRoles;
import com.demo.springMVC.repository.UserRepository;
import com.demo.springMVC.service.UserService;
import com.demo.springMVC.utils.DateUtil;
import com.demo.springMVC.utils.StringEncoderUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return userRepository.userLogin(username, StringEncoderUtil.encode(password));
	}

	@Override
	public void userRegistration(User user, String userPassword) {
		user.setCreated(DateUtil.getCurrentSqlDate());
		user.setRole(UserRoles.USER.name());
		String password = StringEncoderUtil.encode(userPassword);
		userRepository.userRegistration(user, password);
		
	}

	@Override
	public void updateUser(User user) {
		user.setUpdated(DateUtil.getCurrentSqlDate());
		userRepository.updateUser(user);
		
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		user.setUpdated(DateUtil.getCurrentSqlDate());
		userRepository.updatePassword(user, StringEncoderUtil.encode(newPassword));
		
	}

	@Override
	public void deleteUser(User user) {
		user.setDeletedDate(DateUtil.getCurrentSqlDate());
		userRepository.deleteUser(user);
		
	}

}
