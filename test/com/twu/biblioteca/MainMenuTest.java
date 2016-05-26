package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private MainMenu mm;
    private MenuItem mi1;
    private PrintStream mockPrintStream;

    @Before
    public void beforeEach() {
        mi1 = mock(ListOption.class);
        when(mi1.getName()).thenReturn("List Books");
        MenuItem mi2 = mock(ListOption.class);
        when(mi2.getName()).thenReturn("Another List Option");

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.addAll(Arrays.asList(mi1, mi2));

        mockPrintStream = mock(PrintStream.class);

        mm = new MainMenu(items);
    }

    @Test
    public void printOptionsShouldPrintTheListOfAvailableOptions() {
        mm.printOptions(mockPrintStream);
        verify(mockPrintStream).println("List Books");
        verify(mockPrintStream).println("Another List Option");
    }

    @Test
    public void runMenuItemShouldExecuteItemRunMethodForTheCommandPassed() {
        mm.runMenuItem("LB", mockPrintStream);
        verify(mi1, times(1)).run();
    }

    @Test
    public void runMenuItemShouldDisplayAnErrorMessageIfNotAValidCommandHasBeenPassed() {
        mm.runMenuItem("Not valid command", mockPrintStream);
        verify(mockPrintStream).println("Select a valid option!");
    }
}