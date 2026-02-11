package com.aluracursos.screenmatchSpring;

import com.aluracursos.screenmatchSpring.model.DatosSerie;
import com.aluracursos.screenmatchSpring.model.DatosEpisodio;
import com.aluracursos.screenmatchSpring.model.DatosTemporada;
import com.aluracursos.screenmatchSpring.principal.EjemploEstreams;
import com.aluracursos.screenmatchSpring.principal.Principal;
import com.aluracursos.screenmatchSpring.repository.SerieRepository;
import com.aluracursos.screenmatchSpring.service.ConsumoAPI;
import com.aluracursos.screenmatchSpring.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	@Autowired
	private SerieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraMenu();

		//EjemploEstreams ejemploEstreams = new EjemploEstreams();
		//ejemploEstreams.muestraEjemplo();
	}
}
