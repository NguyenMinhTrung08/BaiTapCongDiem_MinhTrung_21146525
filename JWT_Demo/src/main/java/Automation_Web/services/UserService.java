package Automation_Web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Automation_Web.entity.User;
import Automation_Web.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
	this . userRepository = userRepository;
	}
	public List<User> allUsers() {
	List<User> users = new ArrayList<>();
	userRepository.findAll() .forEach(users:: add);
	return users;
	}
}
