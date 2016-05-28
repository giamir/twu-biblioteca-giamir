package com.twu.biblioteca.items;

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
    public String checkOut() {
        super.checkOut();
        return "Thank you! Enjoy the movie";
    }

    @Override
    public String giveBack() {
        super.giveBack();
        return "Thank you for returning the movie.";
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear(), getRating());
    }
}
