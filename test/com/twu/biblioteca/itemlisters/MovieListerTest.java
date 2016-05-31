package com.twu.biblioteca.itemlisters;

import java.util.*;
import com.twu.biblioteca.user.*;
import com.twu.biblioteca.items.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class MovieListerTest {

    private Movie movie1;
    private Movie movie2;
    private MovieLister movieLister;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        movie1 = mock(Movie.class);
        movie2 = mock(Movie.class);
        ArrayList<Item> movieList = new ArrayList<Item>();
        movieList.addAll(Arrays.asList(movie1, movie2));
        movieLister = new MovieLister(movieList);
    }

    @Test
    public void listItemsShouldPrintAllItemsInListerThatAreNotCheckedOut() {
        when(movie1.isCheckedOut()).thenReturn(false);
        when(movie2.isCheckedOut()).thenReturn(true);
        movieLister.listItems();
        verify(movie1, times(1)).printDetails(System.out);
        verify(movie2, never()).printDetails(System.out);
    }

    @Test
    public void checkOutShouldPrintASuccessMessageIfYouCheckedOutSuccessfully() {
        systemInMock.provideLines("The Godfather", "Francis Ford Coppola", "1972");
        when(movie1.isCheckedOut()).thenReturn(false);
        when(movie1.isEqualTo(any(Item.class))).thenReturn(true);
        when(movie1.checkOut(any(User.class))).thenReturn("Thank you! Enjoy the movie");
        movieLister.checkOut(any(User.class));
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy the movie"));
    }

    @Test
    public void checkOutShouldPrintAFailureMessageIfYouCouldNotCheckOut() {
        systemInMock.provideLines("The Godfather", "Francis Ford Coppola", "1972");
        movieLister.checkOut(any(User.class));
        assertTrue(systemOutRule.getLog().contains("That item is not available."));
    }

    @Test
    public void giveBackShouldPrintASuccessMessageIfYouReturnedSuccessfully() {
        systemInMock.provideLines("The Godfather", "Francis Ford Coppola", "1972");
        when(movie1.isCheckedOut()).thenReturn(true);
        when(movie1.isEqualTo(any(Item.class))).thenReturn(true);
        when(movie1.giveBack(any(User.class))).thenReturn("Thank you for returning the movie.");
        movieLister.giveBack(any(User.class));
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the movie."));
    }

    @Test
    public void giveBackShouldPrintAFailureMessageIfYouCouldNotReturn() {
        systemInMock.provideLines("The Godfather", "Francis Ford Coppola", "1972");
        movieLister.giveBack(any(User.class));
        assertTrue(systemOutRule.getLog().contains("That is not a valid item to return."));
    }
}
