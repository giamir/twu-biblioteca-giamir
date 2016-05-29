package com.twu.biblioteca.items;

import com.twu.biblioteca.User;
import java.io.PrintStream;

public interface Item {
    String getTitle();
    String getAuthor();
    int getYear();
    User getHolder();
    void setHolder(User user);
    boolean isCheckedOut();
    boolean isEqualTo(Item item);
    String checkOut();
    String giveBack();
    void printDetails(PrintStream printStream);
}

