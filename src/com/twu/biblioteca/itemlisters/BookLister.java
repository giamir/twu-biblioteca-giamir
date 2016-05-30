package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Book;

import java.util.ArrayList;

public class BookLister extends ItemListerBase implements ItemLister {

    public BookLister(ArrayList<Item> il){
        super(il);
    }

    @Override
    public void checkOut(User user) {
        Book book = new Book(getItemTitle(), getItemAuthor(), getItemYear());
        System.out.println(checkOutItem(book, user));
    }

    @Override
    public void giveBack(User user) {
        Book book = new Book(getItemTitle(), getItemAuthor(), getItemYear());
        System.out.println(giveBackItem(book, user));
    }
}
