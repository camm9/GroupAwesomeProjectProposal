package com.csis3275.model_db;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "UsersDataset")

public class UserDataset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long userDatasetId;
	@Column(name = "matchId")
	private String matchId;
	@Column(name = "dos")
	private String dos;
	@Column(name = "tokeni")
	private Long tokeni;
	
	
	
	@ManyToOne
    @JoinColumn(name="token")
    User user;
	
	public UserDataset() {}
	
	public UserDataset(String matchId, String dos, User user1) {
		this.matchId = matchId;
		this.dos = dos;
		this.user = user1;
		this.tokeni = user1.getUserId();

	}

	public Long getUserDatasetId() {
		return userDatasetId;
	}

	public void setUserDatasetId(Long userDatasetId) {
		this.userDatasetId = userDatasetId;
	}

	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	

	public String getDos() {
		return dos;
	}

	public void setDos(String dos) {
		this.dos = dos;
	}
	
	

}
