package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;

import java.util.ArrayList;

public class MovieLister extends ItemListerBase implements ItemLister {

    public MovieLister(ArrayList<Item> il){
        super(il);
    }

    @Override
    public void checkOut(User user) {
        Movie movie = new Movie(getItemTitle("name"), getItemAuthor("director"), getItemYear());
        System.out.println(checkOutItem(movie, user));
    }

    @Override
    public void giveBack(User user) {
        Movie movie = new Movie(getItemTitle("name"), getItemAuthor("director"), getItemYear());
        System.out.println(giveBackItem(movie, user));
    }
}
