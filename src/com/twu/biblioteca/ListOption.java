package com.twu.biblioteca;

public class ListOption implements MenuItem {

    private String optionName;
    private BookLister bookLister;

    public ListOption(String name, BookLister bl) {
        optionName = name;
        bookLister = bl;
    }

    @Override
    public String getName() {
        return optionName;
    }

    @Override
    public void run(){
        bookLister.listBooks();
    }
}
