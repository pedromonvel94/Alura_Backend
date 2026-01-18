package Proyecto2_POO.Buyit;

import java.util.Comparator;

public class Purchase {
    private String itemName;
    private long itemPrice;

    public Purchase(String itemName, long itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Purchase() {
    }

    public String getItemName() {
        return itemName;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "Purchase {" + " itemName= '" + itemName + '\'' + ", itemPrice= " + itemPrice + " }";
    }
}
