package com.twu.biblioteca.items;

import java.io.PrintStream;
import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieTest {
    private Movie movie;
    private User user;

    @Before
    public void beforeEach() {
        user = mock(User.class);
        movie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 10);
    }

    @Test
    public void getTitleShouldRetrieveMovieName() {
        assertEquals("The Godfather", movie.getTitle());
    }

    @Test
    public void getAuthorShouldRetrieveMovieDirector() {
        assertEquals("Francis Ford Coppola", movie.getAuthor());
    }

    @Test
    public void getYearShouldRetrieveMovieYear() {
        assertEquals(1972, movie.getYear());
    }

    @Test
    public void getRatingShouldRetrieveMovieRating() {
        assertEquals("10", movie.getRating());
    }

    @Test
    public void getHolderShouldRetrieveMovieHolder() { assertEquals(null, movie.getHolder()); }

    @Test
    public void getRatingShouldPrintUnratedIfMovieIsWithNoRating() {
        Movie unratedMovie = new Movie("The Godfather", "Francis Ford Coppola", 1972);
        assertEquals("unrated", unratedMovie.getRating());
    }

    @Test
    public void isEqualToShouldReturnTrueIfTheMoviePassedAsArgumentHaveTheSameProperties() {
        Movie equalMovie = new Movie("The Godfather", "Francis Ford Coppola", 1972, 10);
        assertTrue(movie.isEqualTo(equalMovie));
    }

    @Test
    public void isEqualToShouldReturnFalseIfTheMoviePassedAsArgumentHaveDifferentProperties() {
        Movie differentMovie = new Movie("Life is Beautiful", "Roberto Benigni", 1997, 10);
        assertFalse(movie.isEqualTo(differentMovie));
    }

    @Test
    public void checkOutShouldSetTheStatusOfTheMovieAsCheckedOut() {
        movie.checkOut(user);
        assertTrue(movie.isCheckedOut());
    }

    @Test
    public void checkOutkShouldReturnASuccessCheckOutMessage() {
        assertEquals("Thank you! Enjoy the movie", movie.checkOut(user));
    }

    @Test
    public void checkOutShouldReturnAFailureCheckedMessageIfMovieIsAlreadyCheckedOut() {
        movie.checkOut(user);
        assertEquals("That movie is not available.", movie.checkOut(user));
    }

    @Test
    public void giveBackShouldResetTheStatusOfTheMovieAsCheckedOut() {
        movie.checkOut(user);
        movie.giveBack(user);
        assertFalse(movie.isCheckedOut());
    }

    @Test
    public void giveBackShouldReturnASuccessReturnMessage() {
        movie.checkOut(user);
        assertEquals("Thank you for returning the movie.", movie.giveBack(user));
    }

    @Test
    public void giveBackShouldReturnAFailureReturnMessageIfMovieIsNotCheckedOut() {
        assertEquals("That is not a valid movie to return.", movie.giveBack(user));
    }

    @Test
    public void printDetailsShouldPrintMovieDetails() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        movie.printDetails(mockPrintStream);
        verify(mockPrintStream).printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", "The Godfather", "Francis Ford Coppola", 1972, "10");
    }
}
