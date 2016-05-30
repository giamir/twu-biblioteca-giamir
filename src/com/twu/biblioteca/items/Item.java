package com.twu.biblioteca.items;

import java.io.PrintStream;
import com.twu.biblioteca.user.User;

public interface Item {
    String getTitle();
    String getAuthor();
    int getYear();
    User getHolder();
    boolean isCheckedOut();
    boolean isEqualTo(Item item);
    String checkOut(User user);
    String giveBack(User user);
    void printDetails(PrintStream printStream);
}

