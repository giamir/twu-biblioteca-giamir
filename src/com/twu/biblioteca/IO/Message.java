package com.twu.biblioteca.IO;

import java.io.PrintStream;

public class Message {

    public static final String BIBLIOTECA_WELCOME_MSG = "WELCOME TO BIBLIOTECA";

    public static void printWelcome(PrintStream ps) {
        ps.println(BIBLIOTECA_WELCOME_MSG);
    }
}
