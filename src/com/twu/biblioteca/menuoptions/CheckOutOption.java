package com.twu.biblioteca.menuoptions;

import com.twu.biblioteca.BookLister;

public class CheckOutOption implements MenuItem {

    private String optionName;
    private BookLister bookLister;

    public CheckOutOption(String name, BookLister bl) {
        optionName = name;
        bookLister = bl;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    public void run(){
        bookLister.checkOut();
    }
}
