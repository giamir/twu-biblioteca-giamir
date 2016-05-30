package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogoutOptionTest {

    private LogoutOption lo;
    private UserManager um;

    @Before
    public void beforeEach(){
        um = mock(UserManager.class);
        lo = new LogoutOption("User Logout", um);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("User Logout", lo.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        lo.run();
        verify(um, times(1)).logout(System.out);
    }
}
