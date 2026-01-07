package com.aluracursos.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")//Esta es una de las formas de mapear atributos cuando los nombres no coinciden, sin embargo vamos a usar otra forma mas global en la clase que maneja el Gson
    private String nombre;

    @SerializedName("Year")
    private int fechaDeLanzamiento;

    //@SerializedName("Runtime")
    private int duracionEnMinutos;

    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void muestraFichaTecnica(){
        System.out.println("El titulo que quieres ver es: " + nombre);
        System.out.println("Su fecha de lanzamiento fue en: " + fechaDeLanzamiento);
        System.out.println("El titulo esta en el plan: " + (incluidoEnElPlan ? "True" : "False"));
        System.out.println("La duracion del titulo es: "+ getDuracionEnMinutos() + " minutos");
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones/totalEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean getIsIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public double getSumaDeLasEvaluaciones() {
        return sumaDeLasEvaluaciones;
    }

    public int getTotalEvaluaciones() {
        return totalEvaluaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIsIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "Titulo: " + nombre + " (Año de lanzamiendo: " + fechaDeLanzamiento + ")";
    }
}
