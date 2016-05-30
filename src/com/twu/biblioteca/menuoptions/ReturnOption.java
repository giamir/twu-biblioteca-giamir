package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.ItemLister;

public class ReturnOption extends MenuItemBase implements MenuItem {

    private ItemLister itemLister;

    public ReturnOption(String name, ItemLister il) {
        super(name);
        itemLister = il;
    }

    @Override
    public void run() {
        itemLister.giveBack();
    }

    @Override
    public boolean showWhenLoggedInOnly() { return true; }
}