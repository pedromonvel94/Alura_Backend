public class Decisiones {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.2;
        String plan = "Plus";

        if (fechaDeLanzamiento >= 2022){
            System.out.println("Peliculas mas populares");
        } else {
            System.out.println("Peliculas retro que aun vale la pena ver");
        }

        if (incluidoEnElPlan && plan.equals("Plus")){
            System.out.println("Disfrute de su pelicula");
        } else {
            System.out.println("Pelicula no disponible en su plan actual");
        }
    }
}
