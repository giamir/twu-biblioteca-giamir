package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.itemlisters.BookLister;

public class ReturnOption implements MenuItem {

    private String optionName;
    private BookLister bookLister;

    public ReturnOption(String name, BookLister bl) {
        optionName = name;
        bookLister = bl;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    public void run(){
        bookLister.giveBack();
    }
}