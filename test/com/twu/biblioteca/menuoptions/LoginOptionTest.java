package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginOptionTest {

    private LoginOption loginOption;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        userManager = mock(UserManager.class);
        loginOption = new LoginOption("User Login", userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("User Login", loginOption.getName());
    }

    @Test
    public void runShouldExecuteAuthenticateMethodOfUserManager() {
        loginOption.run();
        verify(userManager, times(1)).authenticate(System.out);
    }
}
