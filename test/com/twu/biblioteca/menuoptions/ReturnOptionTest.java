package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;
import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReturnOptionTest {

    private ReturnOption returnOption;
    private BookLister bookLister;
    private UserManager userManager;

    @Before
    public void beforeEach(){
        bookLister = mock(BookLister.class);
        userManager = mock(UserManager.class);
        returnOption = new ReturnOption("Return", bookLister, userManager);
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Return", returnOption.getName());
    }

    @Test
    public void runShouldExecuteGiveBackMethodOfBookLister() {
        returnOption.run();
        verify(bookLister, times(1)).giveBack(userManager.getCurrentUser());
    }
}