package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;

import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnOptionTest {

    private ReturnOption ro;
    private BookLister bl;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        bl = mock(BookLister.class);
        userManager = mock(UserManager.class);
        ro = new ReturnOption("Return", bl, userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Return", ro.getName());
    }

    @Test
    public void runShouldExecuteGiveBackMethodOfBookLister() {
        ro.run();
        verify(bl, times(1)).giveBack(userManager.getCurrentUser());
    }
}