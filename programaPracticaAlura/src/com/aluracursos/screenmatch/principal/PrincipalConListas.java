package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(6);
        Pelicula miPelicula2 = new Pelicula("Matrix",2001);
        miPelicula2.evalua(9);
        Pelicula peliculaDeBruno = new Pelicula("El señor de los anillos",2001);
        peliculaDeBruno.evalua(10);

        Serie houseOfTheDragon = new Serie("House of the Dragon", 2022);
        houseOfTheDragon.evalua(10);

        ArrayList<Titulo> lista = new ArrayList<>(); //Dentro de los <>, se debe colocar el tipo de dato que va a tener cada uno de los objetos que vamos a almacenar dentro del ArrayList
        lista.add(miPelicula);
        lista.add(miPelicula2);
        lista.add(peliculaDeBruno);
        lista.add(houseOfTheDragon);

        for(Titulo item : lista){
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println(pelicula.getClasificacion());
            }

        };
    }
}
