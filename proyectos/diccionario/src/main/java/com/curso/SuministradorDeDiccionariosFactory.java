package com.curso;


import com.curso.impl.SuministradorDeDiccionariosDesdeFicheros;

public class SuministradorDeDiccionariosFactory {
    
    static SuministradorDeDiccionarios getInstance(){
        //throw RuntimeException("No implementado todavia");
        return new SuministradorDeDiccionariosDesdeFicheros();
    }

}