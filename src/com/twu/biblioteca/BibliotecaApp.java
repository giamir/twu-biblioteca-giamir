package com.twu.biblioteca;

import com.twu.biblioteca.items.*;
import com.twu.biblioteca.itemlisters.*;
import com.twu.biblioteca.menuoptions.*;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserManager;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.go();
    }

    public void go() {
        Message message = new Message(System.out);
        message.printWelcome();

        UserManager userManager = new UserManager(makeUserList());
        MainMenu mainMenu = new MainMenu(makeMenuItems(userManager), userManager);

        while(true) {
            mainMenu.printOptions(System.out);
            mainMenu.runMenuItem(System.out);
        }
    }

    private ArrayList<MenuItem> makeMenuItems(UserManager userManager) {
        BookLister bookLister = new BookLister(makeBookList());
        MovieLister movieLister = new MovieLister(makeMovieList());
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new ListOption("List Books", bookLister));
        items.add(new ListOption("List Movies", movieLister));
        items.add(new CheckOutOption("Check Out Book", bookLister, userManager));
        items.add(new CheckOutOption("Check Out Movie", movieLister, userManager));
        items.add(new ReturnOption("Return Book", bookLister, userManager));
        items.add(new ReturnOption("Return Movie", movieLister, userManager));
        items.add(new LoginOption("Sign In", userManager));
        items.add(new LogoutOption("Sign Out", userManager));
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

    private ArrayList<User> makeUserList() {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("123-4567", "password1"));
        userList.add(new User("234-5678", "password2"));
        userList.add(new User("345-6789", "password3"));
        return userList;
    }
}
