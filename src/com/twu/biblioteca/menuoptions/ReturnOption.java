package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.UserManager;
import com.twu.biblioteca.itemlisters.ItemLister;

public class ReturnOption extends MenuItemBase implements MenuItem {

    private ItemLister itemLister;
    private UserManager userManager;

    public ReturnOption(String name, ItemLister il, UserManager um) {
        super(name);
        itemLister = il;
        userManager = um;
    }

    @Override
    public void run() {
        itemLister.giveBack(userManager.getCurrentUser());
    }

    @Override
    public boolean showWhenLoggedInOnly() { return true; }
}