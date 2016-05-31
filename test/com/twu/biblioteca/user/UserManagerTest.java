package com.twu.biblioteca.user;

import java.util.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class UserManagerTest {

    private User user1;
    private User user2;
    private UserManager userManager;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        user1 = mock(User.class);
        when(user1.getLibraryNumber()).thenReturn("123-4567");
        when(user1.getPassword()).thenReturn("password");
        user2 = mock(User.class);
        when(user2.getLibraryNumber()).thenReturn("234-5678");
        when(user2.getPassword()).thenReturn("wordpass");
        ArrayList<User> userList = new ArrayList<User>();
        userList.addAll(Arrays.asList(user1, user2));
        userManager = new UserManager(userList);
    }

    @Test
    public void authenticateShouldSetCurrentUser() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        assertEquals(user1, userManager.getCurrentUser());
        assertTrue(userManager.isLoggedIn());
    }

    @Test
    public void authenticateShouldReturnASuccessfullMessageIfTheUserIsLoggedIn() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        assertTrue(systemOutRule.getLog().contains("Logged in successfully"));
    }

    @Test
    public void authenticateShouldReturnAFailureMessageIfTheUserCouldNotLogIn() {
        systemInMock.provideLines("not_correct_user", "password_not_correct");
        userManager.authenticate(System.out);
        assertTrue(systemOutRule.getLog().contains("User and/or Password not correct"));
    }

    @Test
    public void authenticateShouldReturnAFailureMessageIfAUserIsAlreadyLoggedIn() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        userManager.authenticate(System.out);
        assertTrue(systemOutRule.getLog().contains("Already logged in"));
        assertFalse(systemOutRule.getLog().contains("Already logged in Logged in successfully"));
    }

    @Test
    public void logoutShouldResetCurrentUser() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        userManager.logout(System.out);
        assertEquals(null, userManager.getCurrentUser());
        assertFalse(userManager.isLoggedIn());
    }

    @Test
    public void logoutShouldReturnASuccessfullMessageIfTheUserIsLoggedOut() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        userManager.logout(System.out);
        assertTrue(systemOutRule.getLog().contains("Logged out successfully"));
    }

    @Test
    public void logoutShouldReturnAFailureMessageIfNoUserIsLoggedIn() {
        userManager.logout(System.out);
        assertTrue(systemOutRule.getLog().contains("No user is logged in"));
        assertFalse(systemOutRule.getLog().contains("Logged out successfully"));
    }
}
