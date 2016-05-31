package com.twu.biblioteca.menuoptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class QuitOptionTest {

    private QuitOption quitOption;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void beforeEach() {
        quitOption = new QuitOption("Quit");
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Quit", quitOption.getName());
    }

    @Test
    public void runShouldSystemExitWithStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        quitOption.run();
    }

    @Test
    public void showLoggedInOnlyShouldReturnFalse() {
        assertFalse(quitOption.showWhenLoggedInOnly());
    }

    @Test
    public void showLoggedOutOnlyShouldReturnFalse() {
        assertFalse(quitOption.showWhenLoggedOutOnly());
    }
}
