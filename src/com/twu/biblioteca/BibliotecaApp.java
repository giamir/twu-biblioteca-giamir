package com.twu.biblioteca;

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
