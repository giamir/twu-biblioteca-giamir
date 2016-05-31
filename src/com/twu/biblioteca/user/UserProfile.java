package com.twu.biblioteca.user;

import java.io.PrintStream;

public class UserProfile {

    private static final String USER_PROFILE_DETAILS_MSG = "USER PROFILE DETAILS";
    private static final String NAME_MSG = "Name: ";
    private static final String EMAIL_MSG = "Email: ";
    private static final String PHONE_MSG = "Phone: ";

    private String name;
    private String email;
    private String phone;

    public UserProfile(String n, String e, String p) {
        name = n;
        email = e;
        phone = p;
    }

    public void printDetails(PrintStream printStream) {
        printStream.println(USER_PROFILE_DETAILS_MSG);
        printStream.println(NAME_MSG + name);
        printStream.println(EMAIL_MSG + email);
        printStream.println(PHONE_MSG + phone);
    }

}
