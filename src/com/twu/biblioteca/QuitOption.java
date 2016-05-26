package com.twu.biblioteca;

public class QuitOption implements MenuItem {

    private String optionName;

    public QuitOption(String name) {
        optionName = name;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    public void run() {
        System.exit(0);
    }
}
