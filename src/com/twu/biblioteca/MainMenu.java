package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class MainMenu {

    private ArrayList<MenuItem> listOptions;

    public MainMenu(ArrayList<MenuItem> items) {
        listOptions = items;
    }

    public void printListOptions(PrintStream ps) {
        for(MenuItem item: listOptions){
            ps.println(item.getName());
        }
    }
}