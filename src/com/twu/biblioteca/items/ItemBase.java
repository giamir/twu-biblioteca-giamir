package com.twu.biblioteca.items;

import com.twu.biblioteca.*;
import java.io.PrintStream;

abstract public class ItemBase implements Item {

    private String title;
    private String author;
    private int year;
    private boolean checkedOut;
    private User holder;

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
    public User getHolder() {
        return holder;
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
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? "Thank you! Enjoy the item" : "That item is not available.";
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? "Thank you for returning the item." : "That is not a valid item to return.";
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear());
    }

    protected boolean evaluateCheckOut(User user) {
        if(checkedOut) return false;
        holder = user;
        checkedOut = true;
        return true;
    }

    protected boolean evaluateGiveBack(User user) {
        if(checkedOut && holder.equals(user)) {
            holder = null;
            checkedOut = false;
            return true;
        }
        return false;
    }
}