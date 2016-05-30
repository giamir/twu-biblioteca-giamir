package com.twu.biblioteca;

import java.util.*;
import java.io.PrintStream;

import com.twu.biblioteca.IO.Scanner;
import com.twu.biblioteca.menuoptions.*;
import com.twu.biblioteca.user.*;

public class MainMenu {

    private static final String MAIN_MENU_MSG = "MAIN MENU";
    private static final String NOT_VALID_OPTION_MSG = "Select a valid option!";
    private static final String MENU_COMMAND_OPTION_MSG = "a menu command option";

    private ArrayList<MenuItem> items;
    private UserManager userManager;

    public MainMenu(ArrayList<MenuItem> i, UserManager um) {
        items = i;
        userManager = um;
    }

    public void printOptions(PrintStream ps) {
        ps.println("\n" + MAIN_MENU_MSG);
        for(MenuItem item: items){
            if (!isItemDeactivated(item)) ps.println("- " + item.getName() + " [" +  generateCommand(item.getName()) + "]");
        }
        ps.println();
    }

    public void executeMenuItem(PrintStream ps) {
        String userInput = Scanner.getInput(MENU_COMMAND_OPTION_MSG);
        if (isValidOption(userInput)) {
            for (MenuItem item : items) {
                if (!isItemDeactivated(item) && userInput.equalsIgnoreCase(generateCommand(item.getName()))) item.run();
            }
        } else { printNotValidOption(ps); }
    }

    private void printNotValidOption(PrintStream ps) {
        ps.println(NOT_VALID_OPTION_MSG);
    }

    private boolean isValidOption(String userInput){
        return commandList().contains(userInput.toUpperCase());
    }

    private ArrayList<String> commandList(){
        ArrayList<String> commandList = new ArrayList<String>();
        for(MenuItem item: items) {
            if (!isItemDeactivated(item)) commandList.add(generateCommand(item.getName()));
        }
        return commandList;
    }

    private String generateCommand(String input) {
        String[] splitInput = input.split("\\s+");
        String command = "";
        for(String word: splitInput) command += word.substring(0,1);
        return command.toUpperCase();
    }

    private boolean isItemDeactivated(MenuItem item){
        return (userManager.isLoggedIn() && item.showWhenLoggedOutOnly()) ||
                (!userManager.isLoggedIn() && item.showWhenLoggedInOnly());
    }
}