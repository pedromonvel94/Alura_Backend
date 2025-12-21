package proyecto_POO.aural.proyect;

public class Audio {
    private String titulo;
    private int duracionSegundos;
    private int totalReproducciones;
    private int totalMeGusta;
    private int clasificacion;

    public Audio(String titulo, int duracionSegundos, int totalReproducciones, int clasificacion) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.totalReproducciones = totalReproducciones;
        this.totalMeGusta = 0;
        this.clasificacion = clasificacion;
    }

    public Audio() {

    }

    public void meGusta(boolean nuevoMeGusta) {
        if (nuevoMeGusta){
            this.totalMeGusta++;
        }
    }

    public void reproducir() {
        this.totalReproducciones++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public int getTotalReproducciones() {
        return totalReproducciones;
    }

    public void setTotalReproducciones(int totalReproducciones) {
        this.totalReproducciones = totalReproducciones;
    }

    public int getTotalMeGusta() {
        return totalMeGusta;
    }

    public void setTotalMeGusta(int totalMeGusta) {
        this.totalMeGusta = totalMeGusta;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
}
