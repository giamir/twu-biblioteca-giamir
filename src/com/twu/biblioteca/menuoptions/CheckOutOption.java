package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.user.UserManager;
import com.twu.biblioteca.itemlisters.ItemLister;

public class CheckOutOption extends MenuItemBase implements MenuItem {

    private ItemLister itemLister;
    private UserManager userManager;

    public CheckOutOption(String name, ItemLister il, UserManager um) {
        super(name);
        itemLister = il;
        userManager = um;
    }

    @Override
    public void run() {
        itemLister.checkOut(userManager.getCurrentUser());
    }

    @Override
    public boolean showWhenLoggedInOnly() { return true; }
}
