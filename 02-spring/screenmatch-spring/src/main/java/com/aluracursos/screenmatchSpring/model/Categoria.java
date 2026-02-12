package com.aluracursos.screenmatchSpring.model;

public enum Categoria {
    ACCION("Action", "Acción"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    CRIMEN("Crime", "Crimen"),
    DRAMA("Drama", "Drama"),
    FANTASIA("Fantasy", "Fantasía"),
    HISTORICO("History", "Histórico"),
    HORROR("Horror", "Terror"),
    MUSICAL("Musical", "Musical"),
    CIENCIA_FICCION("Sci-Fi", "Ciencia Ficción"),
    SUSPENSO("Thriller", "Suspenso"),
    GUERRA("War", "Guerra"),;

    private String categoriaOmdb;
    private String categoriaEspanol;

    Categoria(String categoriaOmdb, String categoriaEspanol) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaEspanol = categoriaEspanol;

    }

    public static Categoria fromString(String text){
        for(Categoria categoria : Categoria.values()){
            if(categoria.categoriaOmdb.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Categoria fromEspanol(String text){
        for(Categoria categoria : Categoria.values()){
            if(categoria.categoriaEspanol.equalsIgnoreCase(text)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
