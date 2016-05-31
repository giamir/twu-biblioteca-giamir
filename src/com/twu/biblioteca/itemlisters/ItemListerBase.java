package com.twu.biblioteca.itemlisters;

import java.util.ArrayList;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.items.*;

abstract public class ItemListerBase implements ItemLister {

    private static final String ITEM_NOT_AVAILABLE_MSG = "That item is not available.";
    private static final String ITEM_NOT_VALID_TO_RETURN_MSG = "That is not a valid item to return.";

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
}
