package proyecto_POO.aural.proyect;

import java.util.ArrayList;

public class Canciones extends Audio {
    private String artistaPrincipal;
    private ArrayList<String> colaboradores;
    private String genero;
    private int añoLanzamiento;

    public Canciones(String titulo, int duracionSegundos, int totalReproducciones, int clasificacion, String artistaPrincipal, ArrayList<String>  colaboradores, String genero, int añoLanzamiento) {
        super(titulo, duracionSegundos, totalReproducciones, clasificacion);
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

    public void esColaboracion(){
        if (!colaboradores.isEmpty()){
            System.out.print("Ft. ");
            for (int i = 0; i < colaboradores.size(); i++){
                System.out.println(colaboradores.get(i) + " ");
            }
        }
    }
}
