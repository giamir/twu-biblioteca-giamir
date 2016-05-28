package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.ItemLister;

public class ListOption implements MenuItem {

    private String optionName;
    private ItemLister itemLister;

    public ListOption(String name, ItemLister il) {
        optionName = name;
        itemLister = il;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    public void run(){
        itemLister.listItems();
    }
}
