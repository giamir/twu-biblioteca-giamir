package com.twu.biblioteca;

import java.io.PrintStream;

public class Message {
    private PrintStream printStream;

    public Message(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcome() {
        printStream.println("WELCOME TO BIBLIOTECA\n");
    }
}
