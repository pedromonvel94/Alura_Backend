package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021); //Pelicula (Tipo de dato) miPelicula (Nombre de la instancia) = new (Le decimos a java que queremos crear una nueva instancia) Pelicula (De la clase pelicula)
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

        Serie houseOfTheDragon = new Serie("House of the Dragon", 2022);
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

        Pelicula miPelicula2 = new Pelicula("Matrix",2001);
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

        var peliculaDeBruno = new Pelicula("El señor de los anillos",2001); //En nuevas versiones de Java podemos usar var en lugar del tipo de dato normal, y ya que estamos diciendo que es un nuevo objeto de la clase como hacemos con new Pelicula() se infiere que el tipo de dato es Pelicula.
        peliculaDeBruno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>(); //Dentro de los <>, se debe colocar el tipo de dato que va a tener cada uno de los objetos que vamos a almacenar dentro del ArrayList
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(miPelicula2);
        listaDePeliculas.add(peliculaDeBruno);

        System.out.println("Tamaño de la lista de peliculas: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.getFirst().getNombre());
        System.out.println();

        System.out.println(listaDePeliculas); //Al imprimir un ArrayList directamente, Java llama al metodo toString() de cada uno de los objetos que contiene el ArrayList para mostrar su representacion en forma de cadena.

        System.out.println("toString de la pelicula: " + listaDePeliculas.get(2).toString());
    }
}
