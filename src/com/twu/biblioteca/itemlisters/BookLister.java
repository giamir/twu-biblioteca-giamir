package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.bibliotecaitems.BibliotecaItem;
import com.twu.biblioteca.bibliotecaitems.Book;

import java.util.ArrayList;

public class BookLister extends ItemListerBase implements ItemLister {

    public BookLister(ArrayList<BibliotecaItem> il){
        super(il);
    }

    @Override
    public void checkOut() {
        Book book = new Book(super.getItemTitle(), super.getItemAuthor(), super.getItemYear());
        System.out.println(super.checkOutItem(book));
    }

    @Override
    public void giveBack() {
        Book book = new Book(super.getItemTitle(), super.getItemAuthor(), super.getItemYear());
        System.out.println(super.giveBackItem(book));
    }
}
