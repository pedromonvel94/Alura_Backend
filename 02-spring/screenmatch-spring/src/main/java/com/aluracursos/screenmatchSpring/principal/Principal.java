package com.aluracursos.screenmatchSpring.principal;

import com.aluracursos.screenmatchSpring.model.DatosEpisodio;
import com.aluracursos.screenmatchSpring.model.DatosSerie;
import com.aluracursos.screenmatchSpring.model.DatosTemporada;
import com.aluracursos.screenmatchSpring.service.ConsumoAPI;
import com.aluracursos.screenmatchSpring.service.ConvierteDatos;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_KEY = "apikey=8356d9c1";
    private final String URL_BASE = "http://www.omdbapi.com/?"+ API_KEY + "&t=";

    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu() {
        System.out.println("Bienvenido a ScreenMatch");
        System.out.println("Por favor escribe el valor de la serie que deseas buscar: ");

        var serieBuscada = scanner.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + URLEncoder.encode(serieBuscada));

        var datosSerie = conversor.obtenerDatos(json, DatosSerie.class);

        System.out.println(datosSerie);

        //Busca los datos de todas las temporadas
        List<DatosTemporada> datosTemporadas = new ArrayList<>();

        for(int i=1; i <= datosSerie.totalTemporadas(); i++) {
            int numeroTemporada = i;
            json = consumoAPI.obtenerDatos(URL_BASE + URLEncoder.encode(serieBuscada) + "&Season=" + numeroTemporada);
            var datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
            datosTemporadas.add(datosTemporada);
        }

        //datosTemporadas.forEach(System.out::println);
        //System.out.println(datosTemporadas.get(2));
        
        //Mostrar solo el titulo de cada una de las temporadas
        /*
        for (int i = 0; i < datosSerie.totalTemporadas(); i++) {
            List<DatosEpisodio>episodiosTemporada = datosTemporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println("Episodio: " + episodiosTemporada.get(j).titulo());
            }
        }
        */
        //El codigo anterior lo podemos hacer con el mismo fucnionamiento pero con el codigo siguiente usando funciones lambda
        datosTemporadas.forEach(temporada -> temporada.episodios().forEach(episodio -> System.out.println(episodio.titulo()))); //Esto es una funcin lambda, la primera t es el argumento que recibe la funcion y despues de la flecha encontramos todo lo que se quiera que haga la funcion
    }
}
