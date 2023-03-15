package com.curso;


import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Optional;

import com.curso.impl.Utilidades;

public class App2Test {
    

    @ParameterizedTest
    @DisplayName("Esta prueba comprueba la función de la distancia de levesthein")
    @CsvFileSource(resources="/comparacion_palabras.csv", numLinesToSkip=1 )
    public void probarFuncionLevensthein(String palabra1, String palabra2, int distanciaReal){
        int distanciaCalculada= Utilidades.distancia(palabra1, palabra2);
        Assertions.assertEquals(distanciaReal, distanciaCalculada);
    }

}
