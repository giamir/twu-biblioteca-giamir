package com.twu.biblioteca.bibliotecaitems;

import java.io.PrintStream;

public class Movie extends BibliotecaItem {
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

    public String checkOut() {
        super.checkOut();
        return "Thank you! Enjoy the movie";
    }

    public String giveBack() {
        super.giveBack();
        return "Thank you for returning the movie.";
    }

    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear(), getRating());
    }
}
