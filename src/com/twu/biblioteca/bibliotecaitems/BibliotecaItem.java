package com.twu.biblioteca.bibliotecaitems;

import java.io.PrintStream;

public interface BibliotecaItem {
    String getTitle();
    String getAuthor();
    int getYear();
    boolean isCheckedOut();
    boolean isEqualTo(BibliotecaItem item);
    String checkOut();
    String giveBack();
    void printDetails(PrintStream printStream);
}

