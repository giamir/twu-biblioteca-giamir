package com.twu.biblioteca.IO;

import java.io.PrintStream;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageTest {
    @Test
    public void printWelcomeShouldDisplayAWelcomeMessage() {
        String welcomeMessage = "WELCOME TO BIBLIOTECA";
        PrintStream mockPrintStream = mock(PrintStream.class);
        Message.printWelcome(mockPrintStream);
        verify(mockPrintStream).println(welcomeMessage);
    }
}


