import java.util.Scanner;

public class Evaluaciones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double notaPelicula = 0;
        double mediaEvaluaciones = 0;
        double totalEvaluaciones = 0;

        while (notaPelicula != -1) {
            System.out.println("Ingrese la nota que le daria a Matrix");
            notaPelicula = entrada.nextDouble();

            if (notaPelicula != -1){
                mediaEvaluaciones += notaPelicula;
                totalEvaluaciones++;
            }
        }
        System.out.println("La media es: " + mediaEvaluaciones / totalEvaluaciones);
    }
}
