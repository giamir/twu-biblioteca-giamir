package com.twu.biblioteca;

import com.twu.biblioteca.items.*;
import com.twu.biblioteca.itemlisters.*;
import com.twu.biblioteca.menuoptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.go();
    }

    public void go() {
        Message message = new Message(System.out);
        message.printWelcome();

        MainMenu mainMenu = new MainMenu(makeMenuItems());
        mainMenu.printOptions(System.out);

        while(true) mainMenu.runMenuItem(chooseMenuItem(), System.out);
    }

    private ArrayList<MenuItem> makeMenuItems() {
        BookLister bookLister = new BookLister(makeBookList());
        MovieLister movieLister = new MovieLister(makeMovieList());

        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new ListOption("List Books", bookLister));
        items.add(new ListOption("List Movies", movieLister));
        items.add(new CheckOutOption("Check Out Book", bookLister));
        items.add(new CheckOutOption("Check Out Movie", movieLister));
        items.add(new ReturnOption("Return Book", bookLister));
        items.add(new ReturnOption("Return Movie", movieLister));
        items.add(new QuitOption("Quit"));

        return items;
    }

    private ArrayList<Item> makeBookList() {
        ArrayList<Item> bookList = new ArrayList<Item>();
        bookList.add(new Book("High Fidelity", "Nick Hornby", 1995));
        bookList.add(new Book("The Divine Comedy", "Dante Alighieri", 1320));
        bookList.add(new Book("The Decameron", "Giovanni Boccaccio", 1353));
        return bookList;
    }

    private ArrayList<Item> makeMovieList() {
        ArrayList<Item> movieList = new ArrayList<Item>();
        movieList.add(new Movie("Life is Beautiful", "Roberto Benigni", 1997, 10));
        movieList.add(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9));
        movieList.add(new Movie("Gladiator", "Ridley Scott", 2000));
        return movieList;
    }

    private String chooseMenuItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a menu option command (first letter/s): ");
        return scanner.next().toUpperCase();
    }
}
