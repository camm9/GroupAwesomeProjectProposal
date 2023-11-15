package com.csis3275.model_db;

import java.util.List;
import java.util.Set;
import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SiteUsers")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long userId;
	@Column(name = "username", nullable = true)
	private String username;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "password", nullable = true)
	private String password;
	@Column(name = "tokenUser", nullable = true)
	private String tokenUser;
	
	
	// Mapping to the other table
    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserDataset> user;
	
	
	public User(){
		
	}
	
	public User(String tokenUser){
		this.tokenUser = tokenUser;
	}
	
	public User(String username, String email, String password, String tokenUser) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.tokenUser = tokenUser;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getTokenUser() {
		return tokenUser;
	}

	public void setTokenUser(String tokenUser) {
		this.tokenUser = tokenUser;
	}

	
	

}
