package com.vecinitas.entities.security;

public class AuthenticationResponse {
	private String jwtResponse;
	
	public AuthenticationResponse() {}
	
	public AuthenticationResponse(String jwtResponse) {
		super();
		this.jwtResponse = jwtResponse;
	}

	public String getJwtResponse() {
		return jwtResponse;
	}

	public void setJwtResponse(String jwtResponse) {
		this.jwtResponse = jwtResponse;
	}

}
