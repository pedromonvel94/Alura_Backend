package com.aluracursos.screenmatchSpring.principal;

import com.aluracursos.screenmatchSpring.model.DatosEpisodio;
import com.aluracursos.screenmatchSpring.model.DatosSerie;
import com.aluracursos.screenmatchSpring.model.DatosTemporada;
import com.aluracursos.screenmatchSpring.model.Episodio;
import com.aluracursos.screenmatchSpring.service.ConsumoAPI;
import com.aluracursos.screenmatchSpring.service.ConvierteDatos;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

        //Convertir todas las informaciones a una lista del tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios = datosTemporadas.stream() //Creamos la lista de datosEpisodios la cual traera todos los episodios de todas las temporadas ya que trabaja con la lista de temporadas llamada datosTemporadas
                .flatMap(temporada -> temporada.episodios().stream())//Por cada temporada obtenemos la lista de episodios y convertimos esa lista en un stream para poder trabajar con ella
                .collect(Collectors.toList()); //Colocamos todos los datos en una lista mutable, si en lugar de usar collect(Collectors.toList()) usamos toList() obtendriamos una lista inmutable por endre no podriamos añadir ni manipular la informacion

        //Top 5 episodios
        System.out.println("-----------------------------");
        System.out.println("Los 5 mejores episodios son: ");
        datosEpisodios.stream()
                .filter(episodio -> !episodio.evaluacion().equalsIgnoreCase("N/A") )//Aqui estamos diciendo que queremos filtrar cada episodio cuya evaluacion NO equivalga a N/A, es decir que solo queremos los episodios que si tienen evaluacion
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())//sorted organiza de menor a mayor, sin embargo el metodo Comparator.comparing() necesita un parametro que le indique por cual atributo debe ordenar, por ejemplo si queremos ordenar por duracion seria Comparator.comparing( DatosEpisodio::duracionEnMinutos ) y el reversed lo que hace es que sea ordenada al reves, es decir de mayor a menor
                .limit(5)
                .forEach(System.out::println);

        //Convirtiendo los datos a una lista de tipo Episodio
        List<Episodio> episodios = datosTemporadas.stream()//Creo una lista de episodios llamada episodiosm diciendo que es igual a un stream de datosTemporadas
                .flatMap(temporada -> temporada.episodios().stream() //Ya que datosTemporadas es una lista de temporadas, y cada temporada tiene una lista de episodios, uso el flatMap para convertir todo en un unico flujo, donde digo que cata temporada me traiga su lista de episodios y convierta esa lista en un stream
                        .map(datosEpisodio -> new Episodio(temporada.numeroTemporada(),datosEpisodio)))//Con el .map lo que hago es transformar cada elemento de un stream en otro elemento, en este caso estoy diciendo que cada datoEpisodio lo transforme en un nuevo objeto de tipo Episodio, para esto necesito pasarle el numero de temporada (que lo obtengo de temporada.numeroTemporada()) y el propio datosEpisodio
                .collect(Collectors.toList());//Ahora si lo convierto en una lista mutable

        episodios.forEach(System.out::println);

        //Busqueda de pisodios a partir de x año

        System.out.println("A partir de que año");
        var anioLanzamiento = scanner.nextInt();
        scanner.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Mi opción
        System.out.println("Esta es la opcion que yo cree para filtrar los resultados mayores a la fecha");
        episodios.stream()
                .filter(fecha -> fecha.getFechaDeLanzamiento() != null && fecha.getFechaDeLanzamiento().getYear() >= anioLanzamiento)
                .forEach(episodio -> System.out.println(
                        "Temporada " + episodio.getTemporada() +
                                "Episodio " + episodio.getTitulo() +
                                "Fecha de Lanzamiento " + episodio.getFechaDeLanzamiento().format(formato)
                ));
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        //Como lo enseñaron en el curso
        System.out.println("Esta es la opcion que crearon en la certificacion para filtrar los resultados mayores a la fecha");
        LocalDate fechaBusqueda = LocalDate.of(anioLanzamiento,1,1);
        episodios.stream()
                .filter(episodio -> episodio.getFechaDeLanzamiento() != null && episodio.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(episodio -> System.out.println(
                        "Temporada " + episodio.getTemporada() +
                                "Episodio " + episodio.getTitulo() +
                                "Fecha de Lanzamiento " + episodio.getFechaDeLanzamiento().format(formato)
                ));
        System.out.println("--------------------------------------------------------");
        System.out.println("");
    }
}
