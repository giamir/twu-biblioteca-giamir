package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class BookListerTest {
    private Book b1;
    private Book b2;
    private ArrayList<Book> bookList;

    @Before
    public void beforeEach() {
        b1 = mock(Book.class);
        b2 = mock(Book.class);
        bookList = new ArrayList<Book>();
        bookList.addAll(Arrays.asList(b1, b2));
    }

    @Test
    public void listBooksShouldPrintAllBooksInLister() {
        BookLister bl = new BookLister(bookList);
        bl.listBooks();
        verify(b1, times(1)).printDetails(System.out);
        verify(b2, times(1)).printDetails(System.out);
    }
}