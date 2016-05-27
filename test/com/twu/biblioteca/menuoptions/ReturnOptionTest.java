package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.BookLister;
import com.twu.biblioteca.menuoptions.ReturnOption;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnOptionTest {

    private ReturnOption ro;
    private BookLister bl;

    @Before
    public void beforeEach(){
        bl = mock(BookLister.class);
        ro = new ReturnOption("Return", bl);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Return", ro.getName());
    }

    @Test
    public void runShouldExecuteGiveBackMethodOfBookLister() {
        ro.run();
        verify(bl, times(1)).giveBack();
    }
}