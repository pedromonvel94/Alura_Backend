package com.aluracursos.screenmatchSpring.principal;

import com.aluracursos.screenmatchSpring.model.*;
import com.aluracursos.screenmatchSpring.repository.SerieRepository;
import com.aluracursos.screenmatchSpring.service.ConsumoAPI;
import com.aluracursos.screenmatchSpring.service.ConvierteDatos;

import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_KEY = "apikey=8356d9c1";
    private final String URL_BASE = "http://www.omdbapi.com/?"+ API_KEY + "&t=";

    private ConvierteDatos conversor = new ConvierteDatos();

    private List<DatosSerie> datosSeries = new ArrayList<>();
    private SerieRepository repositorio;

    private List<Serie> series;


    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }

    public void muestraMenu() {
        System.out.println("Bienvenido a ScreenMatch");
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por titulo
                    5 - Top 5 series
                    6 - Buscar series por categoria
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriesPorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarSeriesPorCategoria();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }



        /*
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
        */

        /*
        for (int i = 0; i < datosSerie.totalTemporadas(); i++) {
            List<DatosEpisodio>episodiosTemporada = datosTemporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println("Episodio: " + episodiosTemporada.get(j).titulo());
            }
        }
        */

        /*
        //El codigo anterior lo podemos hacer con el mismo fucnionamiento pero con el codigo siguiente usando funciones lambda
        datosTemporadas.forEach(temporada -> temporada.episodios().forEach(episodio -> System.out.println(episodio.titulo()))); //Esto es una funcin lambda, la primera t es el argumento que recibe la funcion y despues de la flecha encontramos todo lo que se quiera que haga la funcion

        //Convertir todas las informaciones a una lista del tipo DatosEpisodio
        List<DatosEpisodio> datosEpisodios = datosTemporadas.stream() //Creamos la lista de datosEpisodios la cual traera todos los episodios de todas las temporadas ya que trabaja con la lista de temporadas llamada datosTemporadas
                .flatMap(temporada -> temporada.episodios().stream())//Por cada temporada obtenemos la lista de episodios y convertimos esa lista en un stream para poder trabajar con ella
                .collect(Collectors.toList()); //Colocamos todos los datos en una lista mutable, si en lugar de usar collect(Collectors.toList()) usamos toList() obtendriamos una lista inmutable por endre no podriamos añadir ni manipular la informacion
        */

        /*Top 5 episodios
        System.out.println("-----------------------------");
        System.out.println("Los 5 mejores episodios son: ");
        datosEpisodios.stream()
                .filter(episodio -> !episodio.evaluacion().equalsIgnoreCase("N/A") )//Aqui estamos diciendo que queremos filtrar cada episodio cuya evaluacion NO equivalga a N/A, es decir que solo queremos los episodios que si tienen evaluacion
                .peek(episodio -> System.out.println("Primer filtro (N/A) " + episodio)) //Este stream intermedio nos permite ver en consola lo que hace el stream hasta este punto, es decir que nos mostrara todos los episodios que pasaron el primer filtro
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())//sorted organiza de menor a mayor, sin embargo el metodo Comparator.comparing() necesita un parametro que le indique por cual atributo debe ordenar, por ejemplo si queremos ordenar por duracion seria Comparator.comparing( DatosEpisodio::duracionEnMinutos ) y el reversed lo que hace es que sea ordenada al reves, es decir de mayor a menor
                .peek(episodio -> System.out.println("Segundo filtro Ordenar de mayor a menor " + episodio))
                .map(episodio -> episodio.titulo().toUpperCase())
                .peek(episodio -> System.out.println("Tercer filtro Mayusculas " + episodio))
                .limit(5)
                .forEach(System.out::println);
        */

        /*Convirtiendo los datos a una lista de tipo Episodio
        List<Episodio> episodios = datosTemporadas.stream()//Creo una lista de episodios llamada episodiosm diciendo que es igual a un stream de datosTemporadas
                .flatMap(temporada -> temporada.episodios().stream() //Ya que datosTemporadas es una lista de temporadas, y cada temporada tiene una lista de episodios, uso el flatMap para convertir todo en un unico flujo, donde digo que cata temporada me traiga su lista de episodios y convierta esa lista en un stream
                        .map(datosEpisodio -> new Episodio(temporada.numeroTemporada(),datosEpisodio)))//Con el .map lo que hago es transformar cada elemento de un stream en otro elemento, en este caso estoy diciendo que cada datoEpisodio lo transforme en un nuevo objeto de tipo Episodio, para esto necesito pasarle el numero de temporada (que lo obtengo de temporada.numeroTemporada()) y el propio datosEpisodio
                .collect(Collectors.toList());//Ahora si lo convierto en una lista mutable

        episodios.forEach(System.out::println);

        */

        /*Busqueda de pisodios a partir de x año
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
        */

        /*
        //Busca episodios por un pedazo del titulo
        System.out.println("Escribe titulo del episodios: ");
        var pedazoTitulo = scanner.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(episodio -> episodio.getTitulo().toLowerCase().contains(pedazoTitulo.toLowerCase()))
                .findFirst();
        if (episodioBuscado.isPresent()){
            System.out.println("Episodio encontrado: ");
            System.out.println("Los datos son: " + episodioBuscado.get());
        } else {
            System.out.println("No se encontro el episodio");
        }
        */

        /*Calcular la evaluacion promedio por temporada
        Map<Integer, Double> evaluacionPorTemporada = episodios.stream()
                .filter(episodio -> episodio.getEvaluacion() > 0.0) //Filtramos los episodios que tienen evaluacion valida
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println("Evaluacion promedio por temporada: " + evaluacionPorTemporada);
        */

        /*Estadisticas de evaluacion de episodios
        DoubleSummaryStatistics estadisticasEpisodios = episodios.stream()
                .filter(episodio -> episodio.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("La media de las evaluaciones es: " + estadisticasEpisodios.getAverage());
        System.out.println("El episodio mejor evaluado es: " + estadisticasEpisodios.getMax());
        System.out.println("El episodio peor evaluado es: " + estadisticasEpisodios.getMin());
        */
    }

    private DatosSerie getDatosSerie() {
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var serieBuscada = scanner.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + URLEncoder.encode(serieBuscada));
        System.out.println(json);
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        return datos;
    }

    private void buscarEpisodioPorSerie() {
        mostrarSeriesBuscadas();
        System.out.println("Escribe el nombre de la serie de la cual deseas buscar los episodios");
        var serieBuscada = scanner.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(serieBuscada.toLowerCase()))
                .findFirst();

        if (serie.isPresent()){
            var serieEncontrada  = serie.get();

            List<DatosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumoAPI.obtenerDatos(URL_BASE + URLEncoder.encode(serieEncontrada.getTitulo()) + "&season=" + i );
                DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
                temporadas.add(datosTemporada);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(temporada -> temporada.episodios().stream()
                            .map(datosEpisodio -> new Episodio(temporada.numeroTemporada(), datosEpisodio)))
                    .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodios);
            repositorio.save(serieEncontrada);
        }
    }

    private void buscarSerieWeb() {
        DatosSerie datos = getDatosSerie();
        Serie serie = new Serie(datos);
        repositorio.save(serie);
        //datosSeries.add(datos);
        System.out.println(datos);
    }

    private void mostrarSeriesBuscadas() {
        series = repositorio.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriesPorTitulo(){
        System.out.println("Escribe el nombre de la serie que deseas buscar");
        var nombreSerie = scanner.nextLine();
        Optional<Serie> serieBuscada = repositorio.findByTituloContainsIgnoreCase(nombreSerie);

        if(serieBuscada.isPresent()){
            System.out.println("La serie buscada es: " + serieBuscada.get());
        } else {
            System.out.println("No se encontro la serie");
        }
    }

    private void buscarTop5Series(){
        List<Serie> topSeries = repositorio.findTop5ByOrderByEvaluacionDesc();
        topSeries.forEach(s -> System.out.println("Serie: " + s.getTitulo() + " Evaluacion: " + s.getEvaluacion()));
    }

    private void buscarSeriesPorCategoria(){
        System.out.println("Escriba el genero de la serie que desea buscar");
        var genero = scanner.nextLine();
        var categoria = Categoria.fromEspanol(genero);
        List<Serie> seriesPorCategoria = repositorio.findByGenero(categoria);
        System.out.println("Las series de la categoria " + genero + " son: ");
        seriesPorCategoria.forEach(System.out::println);
    }
}
