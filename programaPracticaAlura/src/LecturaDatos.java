import java.util.Scanner;

public class LecturaDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de su pelicula favorita");
        String pelicula = scanner.nextLine();
        System.out.println("Ingrese la fecha de lanzamiento");
        int fechaDeLanzamiento = scanner.nextInt();
        System.out.println("Ingrese la nota que le dara a la pelicula");
        double notaPelicula = scanner.nextDouble();

        System.out.println(pelicula);
        System.out.println(fechaDeLanzamiento);
        System.out.println(notaPelicula);
    }
}
