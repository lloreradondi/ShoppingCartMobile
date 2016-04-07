package app.portfolio.ordering.Model;

/**
 * Created by dondi on 4/3/2016.
 */
public class ShoppingCart {
    public ShoppingCart(String itemName, int itemQuantity){
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
    }
    private String itemName;
    private int itemQuantity;

    public String getItemName() {
        return itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }
}
