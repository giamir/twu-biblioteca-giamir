package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserTest {

    private User user;
    private UserProfile userProfile;

    @Before
    public void beforeEach() {
        userProfile = mock(UserProfile.class);
        user = new User("123-4567", "password", userProfile);
    }

    @Test
    public void getLibraryNumberShouldRetrieveTheUserLibraryNumber() {
        assertEquals("123-4567", user.getLibraryNumber());
    }

    @Test
    public void getPasswordShouldRetrieveTheUserPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void printProfileShouldDelegateToPrintDetailsMethodOfUserProfile() {
        user.printProfile(System.out);
        verify(userProfile, times(1)).printDetails(System.out);
    }
}

