package Proyecto2_POO;

import Proyecto2_POO.Buyit.PersonalCard;
import Proyecto2_POO.Buyit.Purchase;

import java.util.*;

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
            System.out.println("Nombre del articulo a comprar: ");
            String itemName = scanner.nextLine();

            System.out.println("Precio del articulo: ");
            long itemPrice = scanner.nextLong();
            scanner.nextLine();

            if(card1.canAfford(itemPrice)){
                Purchase purchase = new Purchase(itemName, itemPrice);

                long newBalance = card1.getBalance() - itemPrice;
                card1.setBalance(newBalance);

                purchaseHistory.add(purchase);

                System.out.println("Compra Realizada!");
                System.out.println("New Balance: " + card1.getBalance());

                System.out.println("¿Desea realizar otra compra? (si/no)");
                String response = scanner.nextLine();

                if(card1.getBalance() == 0){
                    System.out.println("No tienes saldo suficiente para realizar mas compras. " + "\n" + "--------------------------------");

                    purchaseHistory.sort(Comparator.comparingLong(Purchase::getItemPrice).reversed());
                    //Collections.sort(purchaseHistory); Puedo implementar Comparable en Purchase y usar el metodo compareTo o usar Comparator como en la linea de arriba

                    for (Purchase item : purchaseHistory) {
                        System.out.println(item + "\n");
                    }

                    System.out.println("Gracias por usar Buyit, vuelva pronto!" + "\n");
                    continueShopping = false;
                }

                if (response.equalsIgnoreCase("no")) {
                    System.out.println("Historial de compras: " + "\n" + "--------------------------------");
                    for (Purchase item : purchaseHistory) {
                        System.out.println(item);
                    }

                    System.out.println("Gracias por usar Buyit, vuelva pronto!");
                    continueShopping = false;
                }
            }else if (!card1.canAfford(itemPrice)){
                System.out.println("No tienes saldo suficiente para realizar mas compras. " + "\n" + "--------------------------------");

                purchaseHistory.sort(Comparator.comparingLong(Purchase::getItemPrice).reversed());

                for (Purchase item : purchaseHistory) {
                    System.out.println(item + "\n");
                }

                System.out.println("Gracias por usar Buyit, vuelva pronto!" + "\n");
                continueShopping = false;
            }
        }

        System.out.println("El balance de la tarjeta es: " + card1.getBalance());

    }
}
