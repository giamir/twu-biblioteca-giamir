package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserInfoOptionTest {

    private UserInfoOption userInfoOption;
    private User user;

    @Before
    public void beforeEach(){
        user = mock(User.class);
        UserManager userManager = mock(UserManager.class);
        when(userManager.getCurrentUser()).thenReturn(user);
        userInfoOption = new UserInfoOption("User Details", userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("User Details", userInfoOption.getName());
    }

    @Test
    public void runShouldExecutePrintProfileMethodOfCurrentUser() {
        userInfoOption.run();
        verify(user, times(1)).printProfile(System.out);
    }

    @Test
    public void showLoggedInOnlyShouldReturnTrue() {
        assertTrue(userInfoOption.showWhenLoggedInOnly());
    }

    @Test
    public void showLoggedOutOnlyShouldReturnFalse() {
        assertFalse(userInfoOption.showWhenLoggedOutOnly());
    }
}
