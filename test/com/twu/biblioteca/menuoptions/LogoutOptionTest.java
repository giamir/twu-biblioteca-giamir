package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogoutOptionTest {

    private LogoutOption logoutOption;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        userManager = mock(UserManager.class);
        logoutOption = new LogoutOption("User Logout", userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("User Logout", logoutOption.getName());
    }

    @Test
    public void runShouldExecuteListBooksMethodOfBookLister() {
        logoutOption.run();
        verify(userManager, times(1)).logout(System.out);
    }
}
