package Automation_Web.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Automation_Web.entity.UserInfo;
import Automation_Web.repository.UserInfoRepository;

@Service

	public record UserService(UserInfoRepository repository,
	PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo) {
	userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	repository. save(userInfo);
	return "Them user thanh cong!";
}
	}
