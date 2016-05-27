package com.twu.biblioteca;

import java.io.PrintStream;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() { return year; }

    public boolean isCheckedOut() { return checkedOut; }

    public boolean isEqualTo(Book book) {
        return title.equals(book.getTitle()) && author.equals(book.getAuthor()) && year == book.getYear();
    }

    public String checkOut() {
        checkedOut = true;
        return "Thank you! Enjoy the book";
    }

    public String giveBack() {
        checkedOut = false;
        return "Thank you for returning the book.";
    }

    public void printDetails(PrintStream printStream) {
        printStream.println(getTitle()+"\t"+getAuthor()+"\t"+getYear());
    }
}
