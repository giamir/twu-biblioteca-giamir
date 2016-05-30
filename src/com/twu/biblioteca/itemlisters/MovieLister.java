package com.twu.biblioteca.itemlisters;

import java.util.ArrayList;
import com.twu.biblioteca.IO.Scanner;
import com.twu.biblioteca.items.*;
import com.twu.biblioteca.user.User;

import java.util.ArrayList;

public class MovieLister extends ItemListerBase implements ItemLister {

    public MovieLister(ArrayList<Item> il){
        super(il);
    }

    @Override
    public void checkOut(User user) {
        Movie movie = new Movie(Scanner.getInput("name"), Scanner.getInput("director"), Integer.parseInt(Scanner.getInput("year")));
        System.out.println(checkOutItem(movie, user));
    }

    @Override
    public void giveBack(User user) {
        Movie movie = new Movie(Scanner.getInput("name"), Scanner.getInput("director"), Integer.parseInt(Scanner.getInput("year")));
        System.out.println(giveBackItem(movie, user));
    }
}
