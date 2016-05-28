package com.twu.biblioteca.menuoptions;

abstract public class MenuItemBase implements MenuItem {

    private String optionName;

    public MenuItemBase(String name) {
        optionName = name;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    abstract public void run();
}
