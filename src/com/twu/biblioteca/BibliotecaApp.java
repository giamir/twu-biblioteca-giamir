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
        ArrayList<Book> bookList = makeBookList();
        BookLister bookLister = new BookLister(bookList);
        bookLister.listBooks();
    }

    private ArrayList<Book> makeBookList(){
        Book b1 = new Book("High Fidelity", " Nick Hornby", 1995);
        Book b2 = new Book("The Divine Comedy", "Dante Alighieri", 1320);
        Book b3 = new Book("The Decameron", "Giovanni Boccaccio", 1353);
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.addAll(Arrays.asList(b1, b2, b3));
        return bookList;
    }
}
