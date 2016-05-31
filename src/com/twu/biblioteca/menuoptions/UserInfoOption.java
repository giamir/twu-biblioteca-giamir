package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;

public class UserInfoOption extends MenuItemBase implements MenuItem {

    private UserManager userManager;

    public UserInfoOption(String name, UserManager um) {
        super(name);
        userManager = um;
    }

    @Override
    public void run() {
        userManager.getCurrentUser().printProfile(System.out);
    }

    @Override
    public boolean showWhenLoggedInOnly() { return true; }
}
