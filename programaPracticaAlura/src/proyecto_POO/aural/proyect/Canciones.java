package proyecto_POO.aural.proyect;

import java.util.ArrayList;

public class Canciones extends Audio implements Interacciones{
    private String artistaPrincipal;
    private ArrayList<String> colaboradores;
    private String genero;
    private int añoLanzamiento;

    public Canciones(String titulo, int duracionSegundos, int totalReproducciones, String artistaPrincipal, ArrayList<String>  colaboradores, String genero, int añoLanzamiento) {
        super(titulo, duracionSegundos, totalReproducciones);
        this.artistaPrincipal = artistaPrincipal;
        this.colaboradores = colaboradores;
        this.genero = genero;
        this.añoLanzamiento = añoLanzamiento;
    }

    public Canciones() {
        super();
        this.colaboradores = new ArrayList<>();
    }

    public String getArtistaPrincipal() {
        return artistaPrincipal;
    }

    public void setArtistaPrincipal(String artistaPrincipal) {
        this.artistaPrincipal = artistaPrincipal;
    }

    public ArrayList<String>  getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<String>  colaboradores) {
        this.colaboradores = colaboradores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAñoLanzamiento() {
        return añoLanzamiento;
    }

    public void setAñoLanzamiento(int añoLanzamiento) {
        this.añoLanzamiento = añoLanzamiento;
    }

    public void agregarColaborador(String colaborador) {
        colaboradores.add(colaborador);
    }

    public String esColaboracion() {
        if (colaboradores.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(" Ft. ");
        for (int i = 0; i < colaboradores.size(); i++) {
            stringBuilder.append(colaboradores.get(i));
            if (i < colaboradores.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void play() {
        if (colaboradores.isEmpty()){
            System.out.println("Escuchando la cancion: " + getTitulo() + " de " + getArtistaPrincipal());
            reproducir();
        }else {
            System.out.print("Escuchando la cancion: " + getTitulo() + " de " + getArtistaPrincipal() + esColaboracion());
            System.out.println("");
            System.out.println("-------------------------------");
            reproducir();

        }
    }

    @Override
    public void pause() {
        System.out.println("La cancion: " + getTitulo() + " de " + getArtistaPrincipal() + esColaboracion() + " esta en PAUSA");
    }
}
