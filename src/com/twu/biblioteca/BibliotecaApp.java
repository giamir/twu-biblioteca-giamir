package com.twu.biblioteca;

import com.twu.biblioteca.bibliotecaitems.BibliotecaItem;
import com.twu.biblioteca.bibliotecaitems.Book;
import com.twu.biblioteca.itemlisters.BookLister;
import com.twu.biblioteca.menuoptions.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    private ArrayList<BibliotecaItem> makeBookList() {
        Book b1 = new Book("High Fidelity", "Nick Hornby", 1995);
        Book b2 = new Book("The Divine Comedy", "Dante Alighieri", 1320);
        Book b3 = new Book("The Decameron", "Giovanni Boccaccio", 1353);
        ArrayList<BibliotecaItem> bookList = new ArrayList<BibliotecaItem>();
        bookList.addAll(Arrays.asList(b1, b2, b3));
        return bookList;
    }

    private ArrayList<MenuItem> makeMenuItems() {
        BookLister bookLister = new BookLister(makeBookList());
        ListOption listBooks = new ListOption("List Books", bookLister);
        CheckOutOption checkOut = new CheckOutOption("Check Out", bookLister);
        ReturnOption giveBack = new ReturnOption("Return", bookLister);
        QuitOption quit = new QuitOption("Quit");
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.addAll(Arrays.asList(listBooks, checkOut, giveBack, quit));
        return items;
    }

    private String chooseMenuItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a menu option command (first letter/s): ");
        return scanner.next().toUpperCase();
    }
}
