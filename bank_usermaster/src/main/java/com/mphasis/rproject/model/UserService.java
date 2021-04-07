package com.mphasis.rproject.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mphasis.rproject.entity.User;



@Component("us")
public class UserService {
	@Autowired
	UserRepository userRepository;
	public User create(User user) {
		return userRepository.save(user);
	}
	public List<User> read() {
		return userRepository.findAll();
	}
	
	public User validateLogin(String userName, String password) {
		return userRepository.validateLogin(userName, password);
	}
	public User update(User user) {
		return userRepository.save(user);
	}
	public void delete(String userName) {
		User user = userRepository.findById(userName).get();
		userRepository.delete(user);
	}
}
