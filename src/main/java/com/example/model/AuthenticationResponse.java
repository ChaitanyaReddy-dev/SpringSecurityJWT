package com.example.model;

public class AuthenticationResponse {

	private String jwt;

	public AuthenticationResponse(String jwtToken) {
		this.jwt=jwt;
	}

	public void AuthenticationResponse() {

	}

	public void AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
