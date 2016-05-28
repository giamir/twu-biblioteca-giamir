package com.twu.biblioteca;

import java.io.PrintStream;

public class Movie {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;
    private int rating;

    public Movie(String t, String a, int y) {
        this(t, a, y, 0);
    }

    public Movie(String t, String a, int y, int r) {
        title = t;
        author = a;
        year = y;
        checkedOut = false;
        rating = r;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() { return year; }

    public String getRating() {
        if(rating == 0) return "unrated";
        return Integer.toString(rating);
    }

    public boolean isCheckedOut() { return checkedOut; }

    public boolean isEqualTo(Movie movie) {
        return title.equals(movie.getTitle()) && author.equals(movie.getAuthor()) && year == movie.getYear();
    }

    public String checkOut() {
        checkedOut = true;
        return "Thank you! Enjoy the movie";
    }

    public String giveBack() {
        checkedOut = false;
        return "Thank you for returning the movie.";
    }

    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear(), getRating());
    }
}
