package com.twu.biblioteca.user;

import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserProfileTest {

    private UserProfile userProfile;

    @Before
    public void beforeEach() {
        userProfile = new UserProfile("John Doe", "john@doe.com", "+44 0123 456789");
    }

    @Test
    public void printDetailsShouldDisplayTheUserProfileDetails() {
        PrintStream mockPrintStream = mock(PrintStream.class);
        userProfile.printDetails(mockPrintStream);
        verify(mockPrintStream).println("USER PROFILE DETAILS");
        verify(mockPrintStream).println("Name: John Doe");
        verify(mockPrintStream).println("Email: john@doe.com");
        verify(mockPrintStream).println("Phone: +44 0123 456789");
    }
}
