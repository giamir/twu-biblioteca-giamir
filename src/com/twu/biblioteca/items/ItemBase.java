package com.twu.biblioteca.items;

import java.io.PrintStream;

abstract public class ItemBase implements Item {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public ItemBase(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
        checkedOut = false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public boolean isEqualTo(Item item) {
        return title.equals(item.getTitle()) && author.equals(item.getAuthor()) && year == item.getYear();
    }

    @Override
    public String checkOut() {
        checkedOut = true;
        return "Thank you!";
    }

    @Override
    public String giveBack() {
        checkedOut = false;
        return "Thank you for returning the item.";
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear());
    }
}