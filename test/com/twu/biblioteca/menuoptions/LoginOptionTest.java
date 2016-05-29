package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.UserManager;
import com.twu.biblioteca.itemlisters.BookLister;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginOptionTest {

    private LoginOption lo;
    private UserManager um;

    @Before
    public void beforeEach(){
        um = mock(UserManager.class);
        lo = new LoginOption("User Login", um);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("User Login", lo.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        lo.run();
        verify(um, times(1)).authenticate(System.out);
    }
}
