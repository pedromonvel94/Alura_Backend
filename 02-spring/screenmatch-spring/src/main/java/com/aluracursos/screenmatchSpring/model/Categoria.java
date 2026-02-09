package com.aluracursos.screenmatchSpring.model;

public enum Categoria {
    ACCION("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    CRIMEN("Crime"),
    DRAMA("Drama"),
    FANTASIA("Fantasy"),
    HISTORICO("History"),
    HORROR("Horror"),
    MUSICAL("Musical"),
    CIENCIA_FICCION("Sci-Fi"),
    SUSPENSO("Thriller"),
    GUERRA("War");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text){
        for(Categoria categoria : Categoria.values()){
            if(categoria.categoriaOmdb.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
