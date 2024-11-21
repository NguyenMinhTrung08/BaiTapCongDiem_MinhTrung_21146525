package Automation_Web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Automation_Web.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	Optional<UserInfo> findByName(String Username);
}
