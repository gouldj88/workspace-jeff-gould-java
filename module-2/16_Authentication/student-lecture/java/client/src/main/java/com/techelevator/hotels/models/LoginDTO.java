package com.techelevator.hotels.models;

// This will contain the data to be sent to the server when a login is requested

// A POJO for non-application data being sent to a server

public class LoginDTO {

    private String username;
    private String password;

    public LoginDTO(String credentials) {
        String[] parts = credentials.split(",");		// constructor will break apart the credential string
        username = parts[0];
        password = parts[1];
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

