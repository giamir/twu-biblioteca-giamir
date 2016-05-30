package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;

public class Book extends ItemBase implements Item {

    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? "Thank you! Enjoy the book" : "That book is not available.";
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? "Thank you for returning the book." : "That is not a valid book to return.";
    }
}
