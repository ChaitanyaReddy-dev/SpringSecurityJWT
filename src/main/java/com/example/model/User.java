package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Configuration;


@Entity
@Table(name="USERDETAILS")
public class User {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID")
	private int id;
	
	@Column(name ="USERNAME")
	private String userName;
	
	@Column(name ="PASSWORD")
	private String password;
	
	@Column(name ="AUTHORITY")
	private String authority;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}



}
