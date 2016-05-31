package com.twu.biblioteca.user;

import java.util.*;
import java.io.PrintStream;
import com.twu.biblioteca.IO.Scanner;

public class UserManager {

    private static final String NOT_VALID_CREDENTIALS_MSG = "User and/or Password not correct";
    private static final String ALREADY_LOGGED_IN_MSG = "Already logged in";
    private static final String LOGGED_IN_MSG = "Logged in successfully";
    private static final String NOT_LOGGED_IN_MSG = "No user is logged in";
    private static final String LOGGED_OUT_MSG = "Logged out successfully";
    private static final String LIBRARY_NUMBER_MSG = "your library number";
    private static final String PASSWORD_MSG = "your password";

    private ArrayList<User> userList;
    private User currentUser;

    public UserManager(ArrayList<User> ul) {
        userList = ul;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() { return currentUser != null; }

    public void authenticate(PrintStream ps) {
        if (isLoggedIn()) {
            ps.println(ALREADY_LOGGED_IN_MSG);
            return;
        }
        currentUser = retrieveUser(Scanner.getInput(LIBRARY_NUMBER_MSG), Scanner.getInput(PASSWORD_MSG));
        if (!isLoggedIn()) { ps.println(NOT_VALID_CREDENTIALS_MSG); }
        else { ps.println(LOGGED_IN_MSG); }
    }

    public void logout(PrintStream ps) {
        if (!isLoggedIn()) {
            ps.println(NOT_LOGGED_IN_MSG);
            return;
        }
        currentUser = null;
        ps.println(LOGGED_OUT_MSG);
    }

    private User retrieveUser(String libraryNumber, String password) {
        for(User u : userList){
            if(isUserVerified(u, libraryNumber, password)) return u;
        }
        return null;
    }

    private boolean isUserVerified(User user, String libraryNumber, String password){
        return user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password);
    }
}
