package com.twu.biblioteca.items;

import java.io.PrintStream;
import com.twu.biblioteca.user.User;

abstract public class ItemBase implements Item {

    private static final String ITEM_SUCCESSFUL_CHECKOUT_MSG = "Thank you! Enjoy the item";
    private static final String ITEM_NOT_AVAILABLE_MSG = "That item is not available.";
    private static final String ITEM_SUCCESSFUL_RETURN_MSG = "Thank you for returning the item.";
    private static final String ITEM_NOT_VALID_TO_RETURN_MSG = "That is not a valid item to return.";

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
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? ITEM_SUCCESSFUL_CHECKOUT_MSG : ITEM_NOT_AVAILABLE_MSG;
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? ITEM_SUCCESSFUL_RETURN_MSG : ITEM_NOT_VALID_TO_RETURN_MSG;
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