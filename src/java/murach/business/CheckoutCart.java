package murach.business;

import java.io.Serializable;
import java.util.ArrayList;

public class CheckoutCart implements Serializable {
    private ArrayList<LineItem> items;

    public CheckoutCart() {
        items = new ArrayList<LineItem>();
    }
    
    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    public int getCount() {
        return items.size();
    }
    
    public void removeItem(LineItem item) {
        String UserID = item.getUserID();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getUserID().equals(UserID)) {
                items.remove(i);
                return;
            }
        }
    }
    public void addItem(LineItem item) {
        items.add(item);
    }
}