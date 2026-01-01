package Proyecto2_POO.Buyit;

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

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
