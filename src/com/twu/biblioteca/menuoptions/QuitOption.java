package com.twu.biblioteca.menuoptions;

public class QuitOption extends MenuItemBase implements MenuItem {

    private String optionName;

    public QuitOption(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.exit(0);
    }
}
