package com.example.springsecurityjwt.model;

public class AthenticationOutput {
	
	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AthenticationOutput(String jwt) {
		super();
		this.jwt = jwt;
	}

	public AthenticationOutput() {
		super();
	}
	
	

}
