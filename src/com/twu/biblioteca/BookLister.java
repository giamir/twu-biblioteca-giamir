package com.twu.biblioteca;

import java.util.ArrayList;

public class BookLister {
    private ArrayList<Book> bookList;

    public BookLister(ArrayList<Book> bl){
        bookList = bl;
    }

    public void listBooks() {
        for (Book b : bookList) {
            b.printDetails(System.out);
        }
    }
}
