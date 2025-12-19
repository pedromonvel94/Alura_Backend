package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 3){
            System.out.println("Muy bien evaluado en el momento");
        }else if(clasificacion.getClasificacion() <= 2.9){
            System.out.println("No muy recomendado en el momento");
        }
    }
}
