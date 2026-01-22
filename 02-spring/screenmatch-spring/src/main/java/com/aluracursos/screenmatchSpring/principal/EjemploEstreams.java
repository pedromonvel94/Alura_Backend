package com.aluracursos.screenmatchSpring.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploEstreams {
    public void muestraEjemplo(){
        List<String>nombres = Arrays.asList("Pedro", "Fernando", "Jorge", "Juanda", "Santi");

        nombres.stream()
                .sorted()
                .limit(4)
                .filter(nombre -> nombre.startsWith("P")) //Recibo nombre como parametro, y filtro por cada nombre que comience con P
                .map(nombre -> nombre.toUpperCase()) //Recibo nombre como parametro, y convierto a mayusculas cada nombre
                .forEach(System.out::println); //Imprimo cada nombre que queda despues de los filtros y conversiones
    }
}
