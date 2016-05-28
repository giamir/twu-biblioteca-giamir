package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

import com.twu.biblioteca.bibliotecaitems.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class BookListerTest {

    private Book b1;
    private Book b2;
    private ArrayList<Book> bookList;
    private BookLister bookLister;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        b1 = mock(Book.class);
        b2 = mock(Book.class);
        bookList = new ArrayList<Book>();
        bookList.addAll(Arrays.asList(b1, b2));
        bookLister = new BookLister(bookList);
    }

    @Test
    public void listBooksShouldPrintAllBooksInListerThatAreNotCheckedOut() {
        when(b1.isCheckedOut()).thenReturn(false);
        when(b2.isCheckedOut()).thenReturn(true);
        bookLister.listBooks();
        verify(b1, times(1)).printDetails(System.out);
        verify(b2, never()).printDetails(System.out);
    }

    @Test
    public void checkOutShouldPrintASuccessMessageIfYouCheckedOutSuccessfully() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        when(b1.isCheckedOut()).thenReturn(false);
        when(b1.isEqualTo(any(Book.class))).thenReturn(true);
        when(b1.checkOut()).thenReturn("Thank you! Enjoy the book");
        bookLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("Thank you! Enjoy the book"));
    }

    @Test
    public void checkOutShouldPrintAFailureMessageIfYouCouldNotCheckOut() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        bookLister.checkOut();
        assertTrue(systemOutRule.getLog().contains("That book is not available."));
    }

    @Test
    public void giveBackShouldPrintASuccessMessageIfYouReturnedSuccessfully() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        when(b1.isCheckedOut()).thenReturn(true);
        when(b1.isEqualTo(any(Book.class))).thenReturn(true);
        when(b1.giveBack()).thenReturn("Thank you for returning the book.");
        bookLister.giveBack();
        assertTrue(systemOutRule.getLog().contains("Thank you for returning the book."));
    }

    @Test
    public void giveBackShouldPrintAFailureMessageIfYouCouldNotReturn() {
        systemInMock.provideLines("High Fidelity", "Nick Hornby", "1995");
        bookLister.giveBack();
        assertTrue(systemOutRule.getLog().contains("That is not a valid book to return."));
    }
}