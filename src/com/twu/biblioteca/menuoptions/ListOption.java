package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.ItemLister;

public class ListOption extends MenuItemBase implements MenuItem {

    private ItemLister itemLister;

    public ListOption(String name, ItemLister il) {
        super(name);
        itemLister = il;
    }

    @Override
    public void run() {
        itemLister.listItems();
    }
}
