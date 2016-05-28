package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.bibliotecaitems.BibliotecaItem;
import com.twu.biblioteca.bibliotecaitems.Movie;

import java.util.ArrayList;

public class MovieLister extends ItemListerBase implements ItemLister {

    public MovieLister(ArrayList<BibliotecaItem> il){
        super(il);
    }

    @Override
    public void checkOut() {
        Movie movie = new Movie(super.getItemTitle("name"), super.getItemAuthor("director"), super.getItemYear());
        System.out.println(super.checkOutItem(movie));
    }

    @Override
    public void giveBack() {
        Movie movie = new Movie(super.getItemTitle("name"), super.getItemAuthor("director"), super.getItemYear());
        System.out.println(super.giveBackItem(movie));
    }
}
