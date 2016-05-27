package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckOutOptionTest {

    private CheckOutOption co;
    private BookLister bl;

    @Before
    public void beforeEach(){
        bl = mock(BookLister.class);
        co = new CheckOutOption("Check Out", bl);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Check Out", co.getName());
    }

    @Test
    public void runShouldExecuteCheckOutMethodOfBookLister() {
        co.run();
        verify(bl, times(1)).checkOut();
    }
}
