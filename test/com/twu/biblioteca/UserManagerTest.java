package com.twu.biblioteca;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserManagerTest {
    private UserManager userManager;
    private User u1;
    private User u2;

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
        userManager.authenticate("123-4567", "password");
        assertEquals(u1, userManager.getCurrentUser());
    }

    @Test
    public void authenticateShouldReturnASuccessfullMessageIfTheUserIsLoggedIn() {
        assertEquals("Logged in successfully", userManager.authenticate("123-4567", "password"));
    }

    @Test
    public void authenticateShouldReturnAFailureMessageIfTheUserCouldNotLogIn() {
        assertEquals("User and/or Password not correct", userManager.authenticate("not_correct_user", "not_correct_password"));
    }

    @Test
    public void authenticateShouldReturnAFailureMessageIfAUserIsAlreadyLoggedIn() {
        userManager.authenticate("123-4567", "password");
        assertEquals("Already logged in", userManager.authenticate("234-5678", "wordpass"));
    }

    @Test
    public void logoutShouldResetCurrentUser() {
        userManager.authenticate("123-4567", "password");
        userManager.logout();
        assertEquals(null, userManager.getCurrentUser());
    }

    @Test
    public void logoutShouldReturnAFailureMessageIfNoUserIsLoggedIn() {
        assertEquals("No user is logged in", userManager.logout());
    }
}
