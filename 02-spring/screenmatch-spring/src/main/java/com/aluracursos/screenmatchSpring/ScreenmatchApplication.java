package com.aluracursos.screenmatchSpring;

import com.aluracursos.screenmatchSpring.model.DatosSerie;
import com.aluracursos.screenmatchSpring.service.ConsumoAPI;
import com.aluracursos.screenmatchSpring.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		String json = consumoAPI.obtenerDatos("http://www.omdbapi.com/?apikey=8356d9c1&t=game+of+thrones");

		System.out.println(json);

		ConvierteDatos conversor = new ConvierteDatos();

		var datos = conversor.obtenerDatos(json, DatosSerie.class);

		System.out.println(datos);
	}
}
