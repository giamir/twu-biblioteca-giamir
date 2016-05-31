package com.twu.biblioteca.user;

import java.io.PrintStream;

public class User {

    private String libraryNumber;
    private String password;
    private UserProfile userProfile;

    public User(String ln, String pwd, UserProfile up) {
        libraryNumber = ln;
        password = pwd;
        userProfile = up;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void printProfile(PrintStream ps) { userProfile.printDetails(ps); }
}
