package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;

import java.io.PrintStream;

public class Movie extends ItemBase implements Item {

    private static final String MOVIE_SUCCESSFUL_CHECKOUT_MSG = "Thank you! Enjoy the movie";
    private static final String MOVIE_NOT_AVAILABLE_MSG = "That movie is not available.";
    private static final String MOVIE_SUCCESSFUL_RETURN_MSG = "Thank you for returning the movie.";
    private static final String MOVIE_NOT_VALID_TO_RETURN_MSG = "That is not a valid movie to return.";
    private static final String MOVIE_UNRATED_MSG = "unrated";

    private int rating;

    public Movie(String t, String a, int y) {
        this(t, a, y, 0);
    }

    public Movie(String t, String a, int y, int r) {
        super(t, a, y);
        rating = r;
    }

    public String getRating() {
        if(rating == 0) return MOVIE_UNRATED_MSG;
        return Integer.toString(rating);
    }

    @Override
    public String checkOut(User user) {
        return evaluateCheckOut(user) ? MOVIE_SUCCESSFUL_CHECKOUT_MSG : MOVIE_NOT_AVAILABLE_MSG;
    }

    @Override
    public String giveBack(User user) {
        return evaluateGiveBack(user) ? MOVIE_SUCCESSFUL_RETURN_MSG : MOVIE_NOT_VALID_TO_RETURN_MSG;
    }

    @Override
    public void printDetails(PrintStream printStream) {
        printStream.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", getTitle(), getAuthor(), getYear(), getRating());
    }
}
