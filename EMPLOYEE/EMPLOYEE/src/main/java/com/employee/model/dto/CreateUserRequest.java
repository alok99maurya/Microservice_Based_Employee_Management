package com.employee.model.dto;


public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String officialEmail;
    private String aadhaarLinkedMobileNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOfficialEmail() {
		return officialEmail;
	}
	public void setOfficialEmail(String officialEmail) {
		this.officialEmail = officialEmail;
	}
	public String getAadhaarLinkedMobileNumber() {
		return aadhaarLinkedMobileNumber;
	}
	public void setAadhaarLinkedMobileNumber(String aadhaarLinkedMobileNumber) {
		this.aadhaarLinkedMobileNumber = aadhaarLinkedMobileNumber;
	}
    
}

