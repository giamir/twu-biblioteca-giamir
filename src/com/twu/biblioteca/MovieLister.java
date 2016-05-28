package com.twu.biblioteca;

import com.twu.biblioteca.bibliotecaitems.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieLister {
    private ArrayList<Movie> movieList;

    public MovieLister(ArrayList<Movie> ml){ movieList = ml; }

    public void listItems() {
        for (Movie m : movieList) {
            if (!m.isCheckedOut()) m.printDetails(System.out);
        }
    }

    public void checkOut() {
        Movie movie = new Movie(getItemTitle(), getItemAuthor(), getItemYear());
        System.out.println(checkOutItem(movie));
    }

    public void giveBack() {
        Movie movie = new Movie(getItemTitle(), getItemAuthor(), getItemYear());
        System.out.println(giveBackItem(movie));
    }

    private String checkOutItem(Movie movie) {
        for(Movie b: movieList){
            if(b.isEqualTo(movie) && !b.isCheckedOut()) return b.checkOut();
        }
        return "That movie is not available.";
    }

    private String giveBackItem(Movie movie) {
        for(Movie m: movieList){
            if(m.isEqualTo(movie) && m.isCheckedOut()) return m.giveBack();
        }
        return "That is not a valid movie to return.";
    }

    private String getItemTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title: ");
        return scanner.nextLine().trim();
    }

    private String getItemAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the author: ");
        return scanner.nextLine().trim();
    }

    private int getItemYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        return scanner.nextInt();
    }
}

