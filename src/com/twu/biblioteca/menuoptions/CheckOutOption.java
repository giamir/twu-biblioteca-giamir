package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.ItemLister;

public class CheckOutOption extends MenuItemBase implements MenuItem {

    private ItemLister itemLister;

    public CheckOutOption(String name, ItemLister il) {
        super(name);
        itemLister = il;
    }

    @Override
    public void run() {
        itemLister.checkOut();
    }
}
