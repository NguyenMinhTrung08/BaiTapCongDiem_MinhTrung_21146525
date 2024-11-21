package Automation_Web.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Automation_Web.entity.User;
import Automation_Web.models.RegisterUserModel;
import Automation_Web.repository.UserRepository;

@Service
public class AuthenticationService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(
	UserRepository userRepository,
	AuthenticationManager authenticationManager,
	PasswordEncoder passwordEncoder)
	{
	this. authenticationManager = authenticationManager;
	this. userRepository = userRepository;
	this. passwordEncoder = passwordEncoder;
	}

	public User signup(RegisterUserModel input) {
	User user = new User();
	user.setFullName(input.getFullName());
	user.setEmail(input.getEmail());
	user.setPassword(passwordEncoder.encode(input.getPassword()));
	return userRepository. save(user);
}
}
