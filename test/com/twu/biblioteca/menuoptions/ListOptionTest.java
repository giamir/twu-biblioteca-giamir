package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;
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
        lo = new ListOption("List Books", bl);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("List Books", lo.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        lo.run();
        verify(bl, times(1)).listItems();
    }
}
