package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListOptionTest {

    private ListOption lo;
    private BookLister bl;

    @Before
    public void beforeEach(){
        bl = mock(BookLister.class);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        lo = new ListOption("List Books", bl);
        assertEquals("List Books", lo.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        lo = new ListOption("List Books", bl);
        lo.run();
        verify(bl, times(1)).listBooks();
    }
}
