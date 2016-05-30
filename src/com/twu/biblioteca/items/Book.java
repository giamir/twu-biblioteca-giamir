package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;

public class Book extends ItemBase implements Item {

    private static final String BOOK_SUCCESSFUL_CHECKOUT_MSG = "Thank you! Enjoy the book";
    private static final String BOOK_NOT_AVAILABLE_MSG = "That book is not available.";
    private static final String BOOK_SUCCESSFUL_RETURN_MSG = "Thank you for returning the book.";
    private static final String BOOK_NOT_VALID_TO_RETURN_MSG = "That is not a valid book to return.";

    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? BOOK_SUCCESSFUL_CHECKOUT_MSG : BOOK_NOT_AVAILABLE_MSG;
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? BOOK_SUCCESSFUL_RETURN_MSG : BOOK_NOT_VALID_TO_RETURN_MSG;
    }
}
