package Automation_Web.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
public class UserInfo {
	private int id;
	private String name;
	private String email;
	private String password;
	private String roles;
}
