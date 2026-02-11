package com.employee.constants;


public class UserCreatedEvent {

    private String userId;
    private String username;
    private String email;
    private String tempPassword;
	public String getUserId() {
		return userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTempPassword() {
		return tempPassword;
	}

	public UserCreatedEvent(String userId, String username, String email, String tempPassword) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.tempPassword = tempPassword;
	}
	
    
}

