package com.twu.biblioteca.itemlisters;

import java.util.ArrayList;
import com.twu.biblioteca.IO.Scanner;
import com.twu.biblioteca.items.*;
import com.twu.biblioteca.user.User;

public class BookLister extends ItemListerBase implements ItemLister {

    public BookLister(ArrayList<Item> il){
        super(il);
    }

    @Override
    public void checkOut(User user) {
        Book book = new Book(Scanner.getInput("title"), Scanner.getInput("author"), Integer.parseInt(Scanner.getInput("year")));
        System.out.println(checkOutItem(book, user));
    }

    @Override
    public void giveBack(User user) {
        Book book = new Book(Scanner.getInput("title"), Scanner.getInput("author"), Integer.parseInt(Scanner.getInput("year")));
        System.out.println(giveBackItem(book, user));
    }
}
