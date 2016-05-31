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

public class BookListerTest {

    private Book book1;
    private Book book2;
    private BookLister bookLister;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        ArrayList<Item> bookList = new ArrayList<Item>();
        bookList.addAll(Arrays.asList(book1, book2));
        bookLister = new BookLister(bookList);
    }

    @Test
    public void listBooksShouldPrintAllBooksInListerThatAreNotCheckedOut() {
        when(book1.isCheckedOut()).thenReturn(false);
        when(book2.isCheckedOut()).thenReturn(true);
        bookLister.listItems();
        verify(book1, times(1)).printDetails(System.out);
        verify(book2, never()).printDetails(System.out);
    }

    @Test
    public void checkOutShouldPrintASuccessMessageIfYouCheckedOutSuccessfully() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        when(book1.isCheckedOut()).thenReturn(false);
        when(book1.isEqualTo(any(Book.class))).thenReturn(true);
        when(book1.checkOut(any(User.class))).thenReturn("Thank you! Enjoy the book");
        bookLister.checkOut(any(User.class));
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy the book"));
    }

    @Test
    public void checkOutShouldPrintAFailureMessageIfYouCouldNotCheckOut() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        bookLister.checkOut(any(User.class));
        assertTrue(systemOutRule.getLog().contains("That item is not available."));
    }

    @Test
    public void giveBackShouldPrintASuccessMessageIfYouReturnedSuccessfully() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        when(book1.isCheckedOut()).thenReturn(true);
        when(book1.isEqualTo(any(Book.class))).thenReturn(true);
        when(book1.giveBack(any(User.class))).thenReturn("Thank you for returning the book.");
        bookLister.giveBack(any(User.class));
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the book."));
    }

    @Test
    public void giveBackShouldPrintAFailureMessageIfYouCouldNotReturn() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        bookLister.giveBack(any(User.class));
        assertTrue(systemOutRule.getLog().contains("That is not a valid item to return."));
    }
}