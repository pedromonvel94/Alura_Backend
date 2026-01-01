package Proyecto2_POO;

import Proyecto2_POO.Buyit.PersonalCard;
import Proyecto2_POO.Buyit.Purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonalCard card1 = new PersonalCard("123456789", "Pedro Montoya");
        List<Purchase> purchaseHistory = new ArrayList<>();

        System.out.println("Bienvenido a Buyit " + card1.getCardOwner() + " su tarjeta con numero: " + card1.getCardNumber() + " ha sido creada.");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Escribe el limite de la tarjeta: ");
        long balance = scanner.nextLong();
        scanner.nextLine();
        card1.setBalance(balance);

        boolean continueShopping = true;

        while (continueShopping){
            if(card1.canAfford()){
                System.out.println("Nombre del articulo a comprar: ");
                String itemName = scanner.nextLine();

                System.out.println("Precio del articulo: ");
                long itemPrice = scanner.nextLong();
                scanner.nextLine();

                Purchase purchase = new Purchase(itemName, itemPrice);

                long newBalance = card1.getBalance() - itemPrice;
                card1.setBalance(newBalance);

                purchaseHistory.add(purchase);

                purchaseHistory.add(new Purchase(purchase.getItemName(), purchase.getItemPrice()));

                System.out.println("Compra Realizada!");
                System.out.println("New Balance: " + card1.getBalance());

                System.out.println("¿Desea realizar otra compra? (si/no)");
                String response = scanner.nextLine();

                if (response.equalsIgnoreCase("no")) {
                    System.out.println("Gracias por usar Buyit, vuelva pronto!");
                    continueShopping = false;
                }
            }else if (!card1.canAfford()){
                System.out.println("No tienes saldo suficiente para realizar mas compras.");
                continueShopping = false;
            };
        }

        System.out.println("El balance de la tarjeta es: " + card1.getBalance());

    }
}
