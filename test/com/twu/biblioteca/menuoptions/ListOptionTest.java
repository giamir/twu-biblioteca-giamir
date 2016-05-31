package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListOptionTest {

    private ListOption listOption;
    private BookLister bookLister;

    @Before
    public void beforeEach(){
        bookLister = mock(BookLister.class);
        listOption = new ListOption("List Books", bookLister);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("List Books", listOption.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        listOption.run();
        verify(bookLister, times(1)).listItems();
    }

    @Test
    public void showLoggedInOnlyShouldReturnFalse() {
        assertFalse(listOption.showWhenLoggedInOnly());
    }

    @Test
    public void showLoggedOutOnlyShouldReturnFalse() {
        assertFalse(listOption.showWhenLoggedOutOnly());
    }
}
