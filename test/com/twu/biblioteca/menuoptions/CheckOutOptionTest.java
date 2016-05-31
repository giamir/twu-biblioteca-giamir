package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;
import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckOutOptionTest {

    private CheckOutOption checkOutOption;
    private BookLister bookLister;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        bookLister = mock(BookLister.class);
        userManager = mock(UserManager.class);
        checkOutOption = new CheckOutOption("Check Out", bookLister, userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Check Out", checkOutOption.getName());
    }

    @Test
    public void runShouldExecuteCheckOutMethodOfBookLister() {
        checkOutOption.run();
        verify(bookLister, times(1)).checkOut(userManager.getCurrentUser());
    }

    @Test
    public void showLoggedInOnlyShouldReturnTrue() {
        assertTrue(checkOutOption.showWhenLoggedInOnly());
    }

    @Test
    public void showLoggedOutOnlyShouldReturnFalse() {
        assertFalse(checkOutOption.showWhenLoggedOutOnly());
    }
}
