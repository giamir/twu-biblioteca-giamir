package com.twu.biblioteca;

import javax.jws.soap.SOAPBinding;
import java.io.PrintStream;
import java.util.*;

public class UserManager {

    private final static String NOT_VALID_CREDENTIALS_MSG = "User and/or Password not correct";
    private final static String ALREADY_LOGGED_IN_MSG = "Already logged in";
    private final static String LOGGED_IN_MSG = "Logged in successfully";
    private final static String NOT_LOGGED_IN_MSG = "No user is logged in";
    private final static String LOGGED_OUT_MSG = "Logged out successfully";

    private ArrayList<User> userList;
    private User currentUser;

    public UserManager(ArrayList<User> ul) {
        userList = ul;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void authenticate(PrintStream ps) {
        if (currentUser != null){
            ps.println(ALREADY_LOGGED_IN_MSG);
            return;
        }
        currentUser = retrieveUser(getLibraryNumber(), getPassword());
        if (currentUser == null) { ps.println(NOT_VALID_CREDENTIALS_MSG); }
        else { ps.println(LOGGED_IN_MSG); }
    }

    public String logout() {
        if (currentUser == null) return NOT_LOGGED_IN_MSG;
        currentUser = null;
        return LOGGED_OUT_MSG;
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

    private String getLibraryNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your library number: ");
        return scanner.nextLine().trim();
    }

    private String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine().trim();
    }
}
