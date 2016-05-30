package com.twu.biblioteca.user;

import com.twu.biblioteca.user.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void beforeEach() {
        user = new User("123-4567", "password");
    }

    @Test
    public void getLibraryNumberShouldRetrieveTheUserLibraryNumber() {
        assertEquals("123-4567", user.getLibraryNumber());
    }

    @Test
    public void getPasswordShouldRetrieveTheUserPassword() {
        assertEquals("password", user.getPassword());
    }
}

