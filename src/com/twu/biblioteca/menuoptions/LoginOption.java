package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.UserManager;

public class LoginOption extends MenuItemBase implements MenuItem {

    private UserManager userManager;

    public LoginOption(String name, UserManager um) {
        super(name);
        userManager = um;
    }

    @Override
    public void run() {
        userManager.authenticate(System.out);
    }
}
