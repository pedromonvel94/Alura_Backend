package proyecto_POO.aural.proyect;

import java.util.Scanner;

public class Podcast extends Audio implements Interacciones{
    Scanner sc = new Scanner(System.in);

    private String descripcionPodcast;
    private String autorPodcast;

    public Podcast(String titulo, int duracionSegundos, int totalReproducciones, int clasificacion, String descripcionPodcast, String autorPodcast) {
        super(titulo, duracionSegundos, totalReproducciones);
        this.descripcionPodcast = descripcionPodcast;
        this.autorPodcast = autorPodcast;
    }

    public Podcast() {
        super();
    }

    public String getDescripcionPodcast() {
        return descripcionPodcast;
    }

    public void setDescripcionPodcast(String descripcionPodcast) {
        this.descripcionPodcast = descripcionPodcast;
    }

    public String getAutorPodcast() {
        return autorPodcast;
    }

    public void setAutorPodcast(String autorPodcast) {
        this.autorPodcast = autorPodcast;
    }

    public void dePagoOGratis(){
        int duracionSegundos = getDuracionSegundos();

        if (duracionSegundos < 0){
            System.out.println("Hay un error con la duracion en segundos");
        }else if(duracionSegundos > 900){
            System.out.println("El podcast es de Pago!");
        }else {
            System.out.println("El podcast es Gratis!");
        }
    }

    public void soloMayoresEdad(){
        int clasificacion = getClasificacion();

        if(clasificacion >= 18){
            System.out.println("El podcast es apto para mayores, digita tu edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if(edad >= 18){
                System.out.println("Bienvenido a: " + getTitulo() + "! Un podcast creado por " + getAutorPodcast() + ", con una duracion de " + getDuracionSegundos() / 60 + " Minutos.");
                reproducir();
            } else if (edad < 0){
                System.out.println("Coloca una edad valida");
            }else {
                System.out.println("No puedes acceder a este podcast");
            }
        }else {
            System.out.println("Bienvenido a: " + getTitulo() + "! Un podcast creado por " + getAutorPodcast() + ", con una duracion de " + getDuracionSegundos() / 60 + " Minutos.");
            reproducir();
        }
    }

    @Override
    public void play() {
        soloMayoresEdad();
    }

    @Override
    public void pause() {
        System.out.println("El podcast " + getTitulo() + " de " + getAutorPodcast() + " esta en PAUSA");
    }
}
