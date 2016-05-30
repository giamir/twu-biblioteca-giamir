package com.twu.biblioteca.IO;

public class Scanner {
    public static String getInput(String toInput){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter " + toInput + ": ");
        return scanner.nextLine().trim();
    }
}