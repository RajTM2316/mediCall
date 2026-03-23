package com.raj.medicall.dto;

public class AdminRegisterRequest {
    private String name;
    private String email;
    private String phoneNo;
    private String password;

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNo() { return phoneNo; }
    public String getPassword() { return password; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setPassword(String password) { this.password = password; }
}