package com.twu.biblioteca;

import java.io.PrintStream;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MessageTest {
    private Message message;

    @Test
    public void printMessageShouldDisplayAWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca";
        PrintStream mockPrintStream = mock(PrintStream.class);

        message = new Message(mockPrintStream);
        message.printWelcome();

        verify(mockPrintStream).println(welcomeMessage);
    }
}


