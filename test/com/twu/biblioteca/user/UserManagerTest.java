package com.twu.biblioteca.user;

import java.util.*;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

public class UserManagerTest {
    private UserManager userManager;
    private User u1;
    private User u2;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        u1 = mock(User.class);
        when(u1.getLibraryNumber()).thenReturn("123-4567");
        when(u1.getPassword()).thenReturn("password");
        u2 = mock(User.class);
        when(u2.getLibraryNumber()).thenReturn("234-5678");
        when(u2.getPassword()).thenReturn("wordpass");
        ArrayList<User> userList = new ArrayList<User>();
        userList.addAll(Arrays.asList(u1, u2));
        userManager = new UserManager(userList);
    }

    @Test
    public void authenticateShouldSetCurrentUser() {
        systemInMock.provideLines("123-4567", "password");
        userManager.authenticate(System.out);
        assertEquals(u1, userManager.getCurrentUser());
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
    public void logoutShouldReturnAFailureMessageIfNoUserIsLoggedIn() {
        userManager.logout(System.out);
        assertTrue(systemOutRule.getLog().contains("No user is logged in"));
    }
}
