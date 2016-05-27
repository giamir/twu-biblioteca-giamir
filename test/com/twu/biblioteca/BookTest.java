package com.twu.biblioteca;

import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {
    private Book book;

    @Before
    public void beforeEach() {
        book = new Book("High Fidelity", "Nick Hornby", 1995);
    }

    @Test
    public void getTitleShouldRetrieveBookTitle() {
        assertEquals("High Fidelity", book.getTitle());
    }

    @Test
    public void getTitleShouldRetrieveBookAuthor() {
        assertEquals("Nick Hornby", book.getAuthor());
    }

    @Test
    public void getTitleShouldRetrieveBookYear() {
        assertEquals(1995, book.getYear());
    }

    @Test
    public void isEqualToShouldReturnTrueIfTheBookPassedHasArgumentHaveTheSameProperties() {
        Book equalBook = new Book("High Fidelity", "Nick Hornby", 1995);
        assertTrue(book.isEqualTo(equalBook));
    }

    @Test
    public void isEqualToShouldReturnFalseIfTheBookPassedHasArgumentHaveDifferentProperties() {
        Book differentBook = new Book("The Divine Comedy", "Dante Alighieri", 1320);
        assertFalse(book.isEqualTo(differentBook));
    }

    @Test
    public void checkOutShouldSetTheStatusOfTheBookAsCheckedOut() {
        book.checkOut();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void giveBackShouldResetTheStatusOfTheBookAsCheckedOut() {
        book.checkOut();
        book.giveBack();
        assertFalse(book.isCheckedOut());
    }

    @Test
    public void printDetailsShouldPrintBookDetails() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        book.printDetails(mockPrintStream);
        verify(mockPrintStream).println("High Fidelity\tNick Hornby\t1995");
    }
}
