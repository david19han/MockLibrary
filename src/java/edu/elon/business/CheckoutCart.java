package edu.elon.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Holds an ArrayList containing all of the lineitem entries from the database.
 * @author davidhan
 */
public class CheckoutCart implements Serializable {
    private ArrayList<LineItem> items;

    public CheckoutCart() {
        items = new ArrayList<LineItem>();
    }
/**
 * Getter method for the ArrayList of lineitems.
 * @return 
 */    
    public ArrayList<LineItem> getItems() {
        return items;
    }
/**
 * Getter method for the size of the arraylist.
 * @return 
 */    
    public int getCount() {
        return items.size();
    }
/**
 * Removes an item from an arraylist when given specific userID.
 * @param userID 
 */    
    public void removeItem(String userID) {
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getUserID().equals(userID)) {
                items.remove(i);
                return;
            }
        }
    }
/**
 * Adds an item to arraylist when given the lineitem.
 * @param item 
 */
    public void addItem(LineItem item) {
        items.add(item);
    }
}