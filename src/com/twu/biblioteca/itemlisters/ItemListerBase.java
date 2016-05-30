package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.items.*;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class ItemListerBase implements ItemLister {

    public static final String ITEM_NOT_AVAILABLE_MSG = "That item is not available.";
    public static final String ITEM_NOT_VALID_TO_RETURN_MSG = "That is not a valid item to return.";

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
        return ITEM_NOT_AVAILABLE_MSG;
    }

    protected String giveBackItem(Item item, User user) {
        for(Item i: itemList){
            if(i.isEqualTo(item)) return i.giveBack(user);
        }
        return ITEM_NOT_VALID_TO_RETURN_MSG;
    }

    protected String getItem(String itemName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the " + itemName + ": ");
        return scanner.nextLine().trim();
    }
}
