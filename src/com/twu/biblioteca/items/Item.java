package com.twu.biblioteca.items;

import java.io.PrintStream;

public interface Item {
    String getTitle();
    String getAuthor();
    int getYear();
    boolean isCheckedOut();
    boolean isEqualTo(Item item);
    String checkOut();
    String giveBack();
    void printDetails(PrintStream printStream);
}

