package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.menuoptions.QuitOption;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitOptionTest {

    private QuitOption qo;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void beforeEach() {
        qo = new QuitOption("Quit");
    }

    @Test
    public void getNameShouldReturnOptionName() {
        assertEquals("Quit", qo.getName());
    }

    @Test
    public void runShouldSystemExitWithStatusCode0() {
        exit.expectSystemExitWithStatus(0);
        qo.run();
    }
}
