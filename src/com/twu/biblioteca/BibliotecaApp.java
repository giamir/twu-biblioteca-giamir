package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.go();
    }

    public void go() {
        Message message = new Message(System.out);
        message.printWelcome();
    }
}
