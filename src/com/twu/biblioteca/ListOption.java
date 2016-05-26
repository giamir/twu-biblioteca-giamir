package com.twu.biblioteca;

public class ListOption implements MenuItem {

    private String optionName;

    public ListOption(String name) {
        optionName = name;
    }

    @Override
    public String getName() {
        return optionName;
    }
}
