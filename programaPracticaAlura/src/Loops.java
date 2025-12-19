import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        double nota = 0;
        double mediaEvaluaciones = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Escribe la nota que le darias a Matrix");
            nota = entrada.nextDouble();

            mediaEvaluaciones = mediaEvaluaciones + nota;
        }
        System.out.println(mediaEvaluaciones / 3);
    }
}
