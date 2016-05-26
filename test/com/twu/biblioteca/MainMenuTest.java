package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private MainMenu mm;

    @Before
    public void beforeEach(){
        MenuItem mi1 = mock(ListOption.class);
        when(mi1.getName()).thenReturn("List Books");
        MenuItem mi2 = mock(ListOption.class);
        when(mi2.getName()).thenReturn("Another List Option");

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.addAll(Arrays.asList(mi1, mi2));

        mm = new MainMenu(items);
    }

    @Test
    public void printListOptionsShouldPrintTheListOfAvailableOptions(){
        PrintStream mockPrintStream = mock(PrintStream.class);
        mm.printListOptions(mockPrintStream);
        verify(mockPrintStream).println("List Books");
        verify(mockPrintStream).println("Another List Option");
    }
}