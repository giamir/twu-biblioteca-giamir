package com.twu.biblioteca.items;

public class Book extends ItemBase implements Item {

    public Book(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public String checkOut() {
        super.checkOut();
        return "Thank you! Enjoy the book";
    }

    @Override
    public String giveBack() {
        super.giveBack();
        return "Thank you for returning the book.";
    }
}
