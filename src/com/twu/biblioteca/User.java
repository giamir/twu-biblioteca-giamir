package com.twu.biblioteca;

public class User {

    private String libraryNumber;
    private String password;

    public User(String ln, String pwd) {
        libraryNumber = ln;
        password = pwd;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
