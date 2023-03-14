package com.curso;

import java.util.*

public interface Diccionario {
    
    boolean existe(String termino);
    
    Optional<List<String>> getDefiniciones(String termino);

    List<String> getSugerencias(String termino);

}