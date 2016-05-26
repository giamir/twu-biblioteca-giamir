package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListOptionTest {

    private ListOption lo;
    private BookLister lb;

    @Test
    public void getNameShouldReturnOptionName() {
        lo = new ListOption("List Books");
        assertEquals("List Books", lo.getName());
    }
}
