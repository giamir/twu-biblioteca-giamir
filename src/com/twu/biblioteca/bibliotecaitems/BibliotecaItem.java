package com.twu.biblioteca.bibliotecaitems;

import java.io.PrintStream;

abstract public class BibliotecaItem {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public BibliotecaItem(String t, String a, int y) {
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

    public int getYear() {
        return year;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public boolean isEqualTo(BibliotecaItem item) {
        return title.equals(item.getTitle()) && author.equals(item.getAuthor()) && year == item.getYear();
    }

    public String checkOut() {
        checkedOut = true;
        return "Thank you!";
    }

    public String giveBack() {
        checkedOut = false;
        return "Thank you for returning the item.";
    }

    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear());
    }
}

