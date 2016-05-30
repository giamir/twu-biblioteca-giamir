package com.twu.biblioteca;

import com.twu.biblioteca.menuoptions.*;
import com.twu.biblioteca.user.UserManager;

import java.util.*;
import java.io.PrintStream;

public class MainMenu {

    private final static String MAIN_MENU_MSG = "MAIN MENU";
    private final static String NOT_VALID_OPTION_MSG = "Select a valid option!";

    private ArrayList<MenuItem> items;
    private UserManager userManager;

    public MainMenu(ArrayList<MenuItem> i, UserManager um) {
        items = i;
        userManager = um;
    }

    public void printOptions(PrintStream ps) {
        ps.println();
        ps.println(MAIN_MENU_MSG);
        for(MenuItem item: items){
            if (isItemDeactiveted(item)) continue;
            ps.println("- " + item.getName() + " [" +  generateCommand(item.getName()) + "]");
        }
    }

    public void runMenuItem(PrintStream ps) {
        String userInput = chooseMenuItem();
        if (isValidOption(userInput)) {
            for (MenuItem item : items) {
                if (isItemDeactiveted(item)) continue;
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
        for(MenuItem item: items) {
            if (isItemDeactiveted(item)) continue;
            commandsList.add(generateCommand(item.getName()));
        }
        return commandsList;
    }

    private String generateCommand(String input) {
        String[] splittedInput = input.split("\\s+");
        String command = "";
        for(String word: splittedInput) command += word.substring(0,1);
        return command.toUpperCase();
    }

    private String chooseMenuItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a menu option command (first letter/s): ");
        return scanner.next().toUpperCase();
    }

    private boolean isItemDeactiveted(MenuItem item){
        return (userManager.isLoggedIn() && item.showWhenLoggedOutOnly()) ||
                (!userManager.isLoggedIn() && item.showWhenLoggedInOnly());
    }
}