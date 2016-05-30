package com.twu.biblioteca.menuoptions;

public interface MenuItem {

    String getName();
    void run();
    boolean showWhenLoggedInOnly();
    boolean showWhenLoggedOutOnly();

}