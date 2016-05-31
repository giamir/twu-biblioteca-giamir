package com.twu.biblioteca.items;

import java.io.PrintStream;
import com.twu.biblioteca.user.User;

abstract public class ItemBase implements Item {

    private static final String ITEM_PRINT_FORMAT = "%-30.30s %-30.30s %-30.30s%n";

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
        return title.equalsIgnoreCase(item.getTitle()) && author.equalsIgnoreCase(item.getAuthor()) && year == item.getYear();
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf(ITEM_PRINT_FORMAT, getTitle(), getAuthor(), getYear());
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