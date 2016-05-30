package com.twu.biblioteca.IO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;


public class ScannerTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void getInputShouldReturnAStringWithTheUserInput() {
        systemInMock.provideLines("my input");
        assertEquals("my input", Scanner.getInput("any word"));

    }
}
