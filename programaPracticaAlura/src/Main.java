import TemperatureTransformer.ConversionTemperaturas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenid(@) a Screen Match");
        System.out.println("Pelicula Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.2;
        double media = (notaPelicula + 6.0 + 9.0) / 3.0;

        System.out.println(media);

        String sinopsis = """
                Matrix es una paradoja
                La mejor pelicula del fin del milenio
                fue lanzada en: 1999
                """;

        System.out.println(sinopsis);

        //Casting de datos

        int clasificacion = (int) media/2;


    }
}