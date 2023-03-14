package com.curso;


public interface SuministradorDeDiccionarios {
    
    boolean tienesDiccionarioDe(String idioma);
    
    Optional<Diccionario> getDiccionario(String idioma);

}