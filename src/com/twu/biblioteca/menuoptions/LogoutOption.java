package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;

public class LogoutOption extends MenuItemBase implements MenuItem {

    private UserManager userManager;

    public LogoutOption(String name, UserManager um) {
        super(name);
        userManager = um;
    }

    @Override
    public void run() {
        userManager.logout(System.out);
    }

    @Override
    public boolean showWhenLoggedInOnly() { return true; }
}