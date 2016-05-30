package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.*;
import com.twu.biblioteca.itemlisters.BookLister;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckOutOptionTest {

    private CheckOutOption co;
    private BookLister bl;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        bl = mock(BookLister.class);
        userManager = mock(UserManager.class);
        co = new CheckOutOption("Check Out", bl, userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Check Out", co.getName());
    }

    @Test
    public void runShouldExecuteCheckOutMethodOfBookLister() {
        co.run();
        verify(bl, times(1)).checkOut(userManager.getCurrentUser());
    }
}
