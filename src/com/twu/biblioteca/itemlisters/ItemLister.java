package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.User;

public interface ItemLister {
    void listItems();
    void checkOut(User user);
    void giveBack(User user);
}