package com.twu.biblioteca;

import java.util.*;

import com.twu.biblioteca.menuoptions.*;
import com.twu.biblioteca.user.UserManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private MainMenu mainMenu;
    private MenuItem listOption;
    private MenuItem loginOption;
    private MenuItem logoutOption;
    private UserManager userManager;

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEach() {
        listOption = mock(ListOption.class);
        when(listOption.getName()).thenReturn("List Books");
        loginOption = mock(LoginOption.class);
        when(loginOption.getName()).thenReturn("Sign In");
        when(loginOption.showWhenLoggedOutOnly()).thenReturn(true);
        logoutOption = mock(LogoutOption.class);
        when(logoutOption.getName()).thenReturn("Sign Out");
        when(logoutOption.showWhenLoggedInOnly()).thenReturn(true);
        userManager = mock(UserManager.class);

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.addAll(Arrays.asList(listOption, loginOption, logoutOption));

        mainMenu = new MainMenu(items, userManager);
    }

    @Test
    public void printOptionsShouldPrintTheListOfAvailableOptionsWhenUserIsLoggedOut() {
        when(userManager.isLoggedIn()).thenReturn(false);
        mainMenu.printOptions(System.out);
        assertTrue(systemOutRule.getLog().contains("- Sign In [SI]"));
        assertFalse(systemOutRule.getLog().contains("- Sign Out [SO]"));
    }

    @Test
    public void printOptionsShouldPrintTheListOfAvailableOptionsWhenUserIsLoggedIn() {
        when(userManager.isLoggedIn()).thenReturn(true);
        mainMenu.printOptions(System.out);
        assertTrue(systemOutRule.getLog().contains("- Sign Out [SO]"));
        assertFalse(systemOutRule.getLog().contains("- Sign In [SI]"));
    }

    @Test
    public void runMenuItemShouldExecuteItemRunMethodForTheCommandPassed() {
        systemInMock.provideLines("LB");
        mainMenu.executeMenuItem(System.out);
        verify(listOption, times(1)).run();
    }

    @Test
    public void runMenuItemShouldDisplayAnErrorMessageIfNotAValidCommandHasBeenPassed() {
        systemInMock.provideLines("not_valid_command");
        mainMenu.executeMenuItem(System.out);
        assertTrue(systemOutRule.getLog().contains("Select a valid option!"));
    }
}