package com.twu.biblioteca.items;

import com.twu.biblioteca.User;

import java.io.PrintStream;

public class Movie extends ItemBase implements Item {
    private int rating;

    public Movie(String t, String a, int y) {
        this(t, a, y, 0);
    }

    public Movie(String t, String a, int y, int r) {
        super(t, a, y);
        rating = r;
    }

    public String getRating() {
        if(rating == 0) return "unrated";
        return Integer.toString(rating);
    }

    @Override
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? "Thank you! Enjoy the movie" : "That movie is not available.";
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? "Thank you for returning the movie." : "That is not a valid movie to return.";
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear(), getRating());
    }
}
