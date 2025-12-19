package AleatoryNumber;

import java.util.Scanner;

public class MainGuesser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreatingAleatoryNumber guesser = new CreatingAleatoryNumber(0);

        int number = 0;
        int numeroAleatorio = guesser.generateNumber();

        System.out.println("Bienvenido a adivina el numero!");
        System.out.println("Ingrese un numero del 0 al 100: ");

        while (number < 5){
            System.out.println("Intento " + (number + 1));
            int opcionUsuario = sc.nextInt();

            if (opcionUsuario >= 0){
                if (opcionUsuario < numeroAleatorio){
                    System.out.println("El numero ingresado es menor");
                } else if (opcionUsuario > numeroAleatorio){
                    System.out.println("El numero ingresado es mayor");
                } else if (opcionUsuario == numeroAleatorio){
                    System.out.println("Adivinaste, el numero!");
                    break;
                }
                number++;
            } else {
                System.out.println("Ingrese un numero del 0 al 100: ");
                opcionUsuario = sc.nextInt();
            }
        }
        System.out.println("El numero correcto era: " + numeroAleatorio);
    }
}
