package com.aluracursos.screenmatchSpring.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase); // Metodo genérico para convertir JSON a cualquier clase ya que puede que en un futuro no queramos convertir a DatosSerie sino a DatosPelicula u otra clase
}
