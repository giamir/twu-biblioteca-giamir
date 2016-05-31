package com.twu.biblioteca.IO;

public class Scanner {

    private static final String ENTER_MSG = "Enter ";

    public static String getInput(String toInput) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(ENTER_MSG + toInput + ": ");
        return scanner.nextLine().trim();
    }
}