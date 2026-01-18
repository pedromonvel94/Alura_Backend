package Proyecto2_POO.Buyit;

public class PersonalCard {
    private long balance;
    private String cardNumber;
    private String cardOwner;

    public PersonalCard(String cardNumber, String cardOwner) {
        this.cardNumber = cardNumber;
        this.cardOwner = cardOwner;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long balance) {
            this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public boolean canAfford(long amount){
        if(this.balance >= amount && this.balance > 0){
            return true;
        } else {
            return false;
        }
    }
}
