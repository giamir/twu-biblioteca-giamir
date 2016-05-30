package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.user.User;

public interface ItemLister {
    void listItems();
    void checkOut(User user);
    void giveBack(User user);
}