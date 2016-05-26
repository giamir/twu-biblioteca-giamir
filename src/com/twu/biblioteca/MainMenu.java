package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class MainMenu {

    private ArrayList<MenuItem> items;

    public MainMenu(ArrayList<MenuItem> i) {
        items = i;
    }

    public void printOptions(PrintStream ps) {
        for(MenuItem item: items){
            ps.println(item.getName());
        }
    }

    public void runMenuItem(String command) {
        for(MenuItem item: items) {
            if (command.equals(generateCommand(item.getName()))) item.run();
        }
    }

    private String generateCommand(String input) {
        String[] splittedInput = input.split("\\s+");
        String command = "";
        for(String word: splittedInput) {
            command += word.substring(0,1);
        }
        return command.toUpperCase();
    }
}