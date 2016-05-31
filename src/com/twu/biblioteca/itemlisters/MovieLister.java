package com.twu.biblioteca.itemlisters;

import java.util.ArrayList;
import com.twu.biblioteca.IO.Scanner;
import com.twu.biblioteca.items.*;
import com.twu.biblioteca.user.User;

public class MovieLister extends ItemListerBase implements ItemLister {

    public MovieLister(ArrayList<Item> il){
        super(il);
    }

    @Override
    public void checkOut(User user) {
        Movie movie = new Movie(Scanner.getInput(NAME_MSG), Scanner.getInput(DIRECTOR_MSG), Integer.parseInt(Scanner.getInput(YEAR_MSG)));
        System.out.println(checkOutItem(movie, user));
    }

    @Override
    public void giveBack(User user) {
        Movie movie = new Movie(Scanner.getInput(NAME_MSG), Scanner.getInput(DIRECTOR_MSG), Integer.parseInt(Scanner.getInput(YEAR_MSG)));
        System.out.println(giveBackItem(movie, user));
    }
}
