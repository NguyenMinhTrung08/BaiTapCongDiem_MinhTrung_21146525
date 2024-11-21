package Automation_Web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Automation_Web.config.UserInfoUserDetails;
import Automation_Web.entity.UserInfo;
import Automation_Web.repository.UserInfoRepository;

public class UserInfoDetailService implements UserDetailsService {

	@Autowired
	
	UserInfoRepository repository;
	
	public UserInfoDetailService(UserInfoRepository userInfoRepository) {
	this.repository = userInfoRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
	Optional<UserInfo> userInfo = repository.findByName(username);
	return userInfo.map(UserInfoUserDetails::new)
	.orElseThrow( () -> new UsernameNotFoundException("user not found: " +
	username ) ) ;
	}
}
