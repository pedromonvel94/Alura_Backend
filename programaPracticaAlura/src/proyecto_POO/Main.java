package proyecto_POO;

import proyecto_POO.aural.proyect.Canciones;
import proyecto_POO.aural.proyect.Podcast;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Podcast podcast1 = new Podcast(
                "The Wild Project",
                900,
                1000,
                18,
                "The wild project by jordi Wild",
                "Jordi Wild"
        );

        Podcast podcast2 = new Podcast(
                "Creativo",
                520,
                800,
                16,
                "Podcast de entrevistas y creatividad con invitados variados",
                "Roberto Mtz"
        );

        podcast1.dePagoOGratis();
        for (int i = 0; i < 10; i++) {
            podcast1.reproducir();
        }

        podcast1.play();
        System.out.println(podcast1.getTotalReproducciones());
        podcast1.pause();

        ArrayList<String> colaboradores = new ArrayList<>();

        Canciones cancion1 = new Canciones(
                "'Dices',", 240, 1000000, "'De la Guetto'", colaboradores, "Reggaeton", 2015
        );

        cancion1.agregarColaborador("Arcangel");
        cancion1.agregarColaborador("Bad Bunny");

        cancion1.play();
        cancion1.pause();

    }
}
