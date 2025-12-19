package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula(); //Pelicula (Tipo de dato) miPelicula (Nombre de la instancia) = new (Le decimos a java que queremos crear una nueva instancia) Pelicula (De la clase pelicula)

        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setIsIncluidoEnElPlan(true);
        miPelicula.setDuracionEnMinutos(130);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(10);
        miPelicula.evalua(6);
        miPelicula.evalua(5);

        System.out.println("----------------------------------------------");
        System.out.println("La pelicula: " + miPelicula.getNombre() + ", Fue lanzada en " + miPelicula.getFechaDeLanzamiento() + "\n" + "Tiene una duracion de: " + miPelicula.getDuracionEnMinutos() + " minutos, y tiene una calificacion de " + miPelicula.calculaMedia() + "\n" + "de un total de " + miPelicula.getTotalEvaluaciones() + " evaluaciones" + "\n" + "Esta incluida en el plan? - " + miPelicula.getIsIncluidoEnElPlan());

        System.out.println("\n" + "----------------------------------------------");

        Serie houseOfTheDragon = new Serie();

        houseOfTheDragon.setNombre("House of the Dragon");
        houseOfTheDragon.setFechaDeLanzamiento(2022);
        houseOfTheDragon.setIsIncluidoEnElPlan(true);
        houseOfTheDragon.setTemporadas(1);
        houseOfTheDragon.setMinutosPorEpisodio(50);
        houseOfTheDragon.setEpisodiosPorTemporada(10);
        System.out.println("La duracion en minutos de la serie es: " + houseOfTheDragon.getDuracionEnMinutos() + " minutos");
        houseOfTheDragon.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();

        calculadora.incluye(miPelicula);
        System.out.println(calculadora.getTiempoTotal());
        calculadora.incluye(houseOfTheDragon);
        System.out.println(calculadora.getTiempoTotal());

        Pelicula miPelicula2 = new Pelicula();

        miPelicula2.setNombre("Matrix");
        miPelicula2.setFechaDeLanzamiento(2001);
        miPelicula2.setIsIncluidoEnElPlan(true);
        miPelicula2.setDuracionEnMinutos(180);

        calculadora.incluye(miPelicula2);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setSerie(houseOfTheDragon);
        episodio.setNombre("El inicio");
        episodio.setNumero(1);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);
    }
}
