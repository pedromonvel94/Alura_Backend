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
        podcast1.soloMayoresEdad();

        Canciones cancion1 = new Canciones();

        cancion1.agregarColaborador("Arcangel");

        cancion1.esColaboracion();








    }
}
