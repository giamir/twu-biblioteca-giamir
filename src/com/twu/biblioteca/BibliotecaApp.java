package com.twu.biblioteca;

import java.util.ArrayList;
import com.twu.biblioteca.IO.*;
import com.twu.biblioteca.items.*;
import com.twu.biblioteca.itemlisters.*;
import com.twu.biblioteca.menuoptions.*;
import com.twu.biblioteca.user.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.go();
    }

    private static void go() {
        Message.printWelcome(System.out);
        UserManager userManager = new UserManager(makeUserList());
        MainMenu mainMenu = new MainMenu(makeMenuItems(userManager), userManager);

        boolean running = true;
        do { mainMenu.printOptions(System.out);
            mainMenu.executeMenuItem(System.out); } while(running);
    }

    private static ArrayList<MenuItem> makeMenuItems(UserManager userManager) {
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
        items.add(new UserInfoOption("User Details", userManager));
        items.add(new QuitOption("Quit"));
        return items;
    }

    private static ArrayList<Item> makeBookList() {
        ArrayList<Item> bookList = new ArrayList<Item>();
        bookList.add(new Book("High Fidelity", "Nick Hornby", 1995));
        bookList.add(new Book("The Divine Comedy", "Dante Alighieri", 1320));
        bookList.add(new Book("The Decameron", "Giovanni Boccaccio", 1353));
        return bookList;
    }

    private static ArrayList<Item> makeMovieList() {
        ArrayList<Item> movieList = new ArrayList<Item>();
        movieList.add(new Movie("Life is Beautiful", "Roberto Benigni", 1997, 10));
        movieList.add(new Movie("The Godfather", "Francis Ford Coppola", 1972, 9));
        movieList.add(new Movie("Gladiator", "Ridley Scott", 2000));
        return movieList;
    }

    private static ArrayList<User> makeUserList() {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("123-4567", "password1", new UserProfile("Giamir", "hello@giamir.com", "+44 0123 456789")));
        userList.add(new User("234-5678", "password2", new UserProfile("John", "john@email.com", "+44 1234 567890")));
        userList.add(new User("345-6789", "password3", new UserProfile("Mary", "mary@email.com", "+44 2345 678901")));
        return userList;
    }
}
