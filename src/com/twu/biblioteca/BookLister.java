package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BookLister {
    private ArrayList<Book> bookList;

    public BookLister(ArrayList<Book> bl){
        bookList = bl;
    }

    public void listBooks() {
        for (Book b : bookList) {
            if (!b.isCheckedOut()) b.printDetails(System.out);
        }
    }

    public void checkOut() {
        Book book = new Book(getItemTitle(), getItemAuthor(), getItemYear());
        System.out.println(checkOutItem(book));
    }

    private String checkOutItem(Book book) {
        for(Book b: bookList){
            if(b.isEqualTo(book) && !b.isCheckedOut()) return b.checkOut();
        }
        return "That book is not available.";
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
