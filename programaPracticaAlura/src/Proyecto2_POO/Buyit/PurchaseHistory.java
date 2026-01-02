package Proyecto2_POO.Buyit;

import java.util.List;

public class PurchaseHistory {
    List<Purchase> purchaseHistory;

    public PurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public void printSummary(List<Purchase> purchaseHistory){
        System.out.println("----- Purchase History Summary -----");
        long totalSpent = 0;
        for (Purchase purchase : purchaseHistory) {
            System.out.println(purchase.toString());
            totalSpent += purchase.getItemPrice();
        }
        System.out.println("Total Spent: " + totalSpent);

    }
}
