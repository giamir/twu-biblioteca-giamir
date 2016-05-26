package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class MainMenu {

    private final static String NOT_VALID_OPTION_MSG = "Select a valid option!";
    private ArrayList<MenuItem> items;

    public MainMenu(ArrayList<MenuItem> i) {
        items = i;
    }

    public void printOptions(PrintStream ps) {
        for(MenuItem item: items){
            ps.println(item.getName());
        }
    }

    public void runMenuItem(String userInput, PrintStream ps) {
        if (isValidOption(userInput)) {
            for (MenuItem item : items) {
                if (userInput.equals(generateCommand(item.getName()))) item.run();
            }
        } else { printNotValidOption(ps); }
    }

    private void printNotValidOption(PrintStream ps) {
        ps.println(NOT_VALID_OPTION_MSG);
    }

    private boolean isValidOption(String userInput){
        return commandsList().contains(userInput);
    }

    private ArrayList<String> commandsList(){
        ArrayList<String> commandsList = new ArrayList<String>();
        for(MenuItem item: items) commandsList.add(generateCommand(item.getName()));
        return commandsList;
    }

    private String generateCommand(String input) {
        String[] splittedInput = input.split("\\s+");
        String command = "";
        for(String word: splittedInput) command += word.substring(0,1);
        return command.toUpperCase();
    }
}