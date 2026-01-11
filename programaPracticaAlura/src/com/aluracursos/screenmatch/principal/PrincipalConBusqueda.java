package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exceptions.ErrorDeConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException { //Estas excepciones se agregan, ya que el metodo send el cual estamos usando para enviar la request puede lanzar estas excepciones (basicamente lo que hacemos aqui es desligarnos de la responsabilidad de manejar estas excepciones y se las pasamos al metodo main, el cual a su vez las pasara a la JVM)

        Scanner lectura = new Scanner(System.in);

        System.out.println("Escriba el nombre de la pelicula que desea buscar: ");
        String busqueda = lectura.nextLine();

        String direccion = "http://www.omdbapi.com/?apikey=8356d9c1&t=" + URLEncoder.encode(busqueda); //Ojo con esta clase, sirve para convertir los espacios en + de forma automatica, lo que es muy necesario para el funcionamiento de URL´s y funciona mucho mejor que un simple replace
        try{
            HttpClient client = HttpClient.newHttpClient(); //Para hacer request vamos a usar una arquitectura llamada cliente - servidor, por ende nosotros vamos a ser los clientes que le van a hacer las peticiones al servidor y para eso usamos el HttpClient
            HttpRequest request = HttpRequest.newBuilder()//Con esta request le decimos al servidor que es lo que queremos obtener de el; adicional a eso podemos ver que esta utilizando un patron de diseño llamado "Builder" el cual identificamos ya que usa el metodo "newBuilder()" y al final cierra con el metodo "build()"; Ahora, que es un patron builder? - basicamente es un patron que nos permite construir algo que puede tener muchas formas, en este caso estamos construyendo una request que solo le vamos a colocar una URI.
                    .uri(URI.create(direccion)) //Aquí es donde debemos indicar el link que direcciona a nuestra api, ya que a esta es a la que le realizaremos las peticiones
                    .build();
            //Algo a tener presente es que nosotros no podemos instanciar la clase HttpRequest directamente con "HttpRequest req = new HttpRequest()" ya que es una clase "abstracta", por ende debemos usar el patron builder para crear una instancia de esta clase.

            HttpResponse<String> response = client //Con el HttpResponse indicamos que es lo que queremos recibir del servidor, en este caso estamos indicando que queremos recibir un String como respuesta del servidor
                    .send(request, HttpResponse.BodyHandlers.ofString()); //Como podemos ver está enviando nuestra request (lo que nosotros queremos pedir) y ademas le estamos diciendo que queremos recibir la respuesta como un String usando el BodyHandlers.ofString() (básicamente el BodyHandler lo que hace es interpretar lo que nosotros queremos recibir).

            String json = response.body();//Con este metodo body() lo que hacemos es obtener el cuerpo de la respuesta que nos envio el servidor (en este caso la informacion de la pelicula Matrix en formato JSON)

            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create(); //Gson es una libreria de Google que nos permite convertir un JSON en un objeto de Java y viceversa (convertir un objeto de Java en un JSON)

            TituloOMDB tituloOMDB = gson.fromJson(json, TituloOMDB.class);

            System.out.println(tituloOMDB);

            Titulo miTitulo = new Titulo(tituloOMDB);
            System.out.println("Titulo ya convertido: " + miTitulo);

            FileWriter escritura = new FileWriter("peliculas.txt");
            escritura.write(miTitulo.toString());
            escritura.close();

        } catch (NumberFormatException e) {
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ocurrio un error en la URI, verifique la direccion: ");
        } catch(ErrorDeConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Finalizo la ejecucion del programa.");

    }

}
