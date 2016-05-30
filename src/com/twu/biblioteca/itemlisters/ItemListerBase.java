package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.User;
import com.twu.biblioteca.items.*;
import sun.rmi.server.UnicastServerRef;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class ItemListerBase implements ItemLister {
    private ArrayList<Item> itemList;

    public ItemListerBase(ArrayList<Item> il){
        itemList = il;
    }

    @Override
    public void listItems() {
        for (Item i : itemList) {
            if (!i.isCheckedOut()) i.printDetails(System.out);
        }
    }

    @Override
    abstract public void checkOut(User user);

    @Override
    abstract public void giveBack(User user);

    protected String checkOutItem(Item item, User user) {
        for(Item i: itemList){
            if(i.isEqualTo(item)) return i.checkOut(user);
        }
        return "That item is not available.";
    }

    protected String giveBackItem(Item item, User user) {
        for(Item i: itemList){
            if(i.isEqualTo(item)) return i.giveBack(user);
        }
        return "That is not a valid item to return.";
    }

    protected String getItemTitle() {
        return getItemTitle("title");
    }

    protected String getItemAuthor() {
        return getItemAuthor("author");
    }

    protected int getItemYear() {
        return getItemYear("year");
    }

    protected String getItemTitle(String whatToEnter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the " + whatToEnter + ": ");
        return scanner.nextLine().trim();
    }

    protected String getItemAuthor(String whatToEnter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the " + whatToEnter + ": ");
        return scanner.nextLine().trim();
    }

    protected int getItemYear(String whatToEnter) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the " + whatToEnter + ": ");
        return scanner.nextInt();
    }
}
