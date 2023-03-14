package com.curso;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class AppTest {
    
    private SuministradorDeDiccionarios miSuministradorDeDiccionarios;
    
    @BeforeAll
    public void obtenerSuministradorDeDiccionarios(){
        this.miSuministradorDeDiccionarios = SuministradorDeDiccionariosFactory.getInstance();
    }

    @Test    
// Comprobar que si pido un diccionario en un idioma existente, el diccionario es devuelto
// Servicio? JAVA 9 -> ServiceLoader.loadService(SuministradorDeDiccionarios.class)
    String idioma = "ES";
    Optional<Diccionario> dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma);
    // Assert? dicEspanol no venga vacio (venga relleno)

// Comprobar que si pido un diccionario en un idioma que no existente, no se devuelve un diccionario
//    - Lanzando una Exception    RUINA !!!!!!        ESTO ES UNA MUY MUY MUY MUY MALA PRACTICA
//        Las excepciones son para tratar casos que no puedo evitar. Eventos que no se si van a ocurrir o no.
//    - nulo                      RUINA !!!!!!        ESTO ES UNA MUY MUY MUY MUY MALA PRACTICA
//                                                    El Sonarqube os lo tira a la basura !
//    - Optional                  GENIAL!!!!!! 
    
    String idioma = "DE LOS ELFOS";
    Optional<Diccionario> dicEspanol = SuministradorDeDiccionarios.getDiccionario(idioma);
    // Assert? dicEspanol venga vacio ( no venga relleno)

// Comprobar que si pregunto si existe un diccionario en un idioma existente, me digan que SI

    String idioma = "ES";
    boolean existe = SuministradorDeDiccionarios.tienesDiccionarioDe(idioma);
    // Assert -> TRUE

// Comprobar que si pregunto si existe un diccionario en un idioma que no existente, me digan que NO

    String idioma = "DE LOS ELFOS";
    boolean existe = SuministradorDeDiccionarios.tienesDiccionarioDe(idioma);
    // Assert -> FALSE

// Comprobar que si a un diccionario que existe le pregunto si existe un término que existe, me diga: que SI
    PRUEBA -> CASOS DE PRUEBA.... multitud de datos manzana, PERRO, perro, Perro, peRRO
    
    String idioma = "ES";
    Diccionario dicEspanol = SuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
    dicEspanol.existe("MANZANA") // ASSERT: TRUE
    
// Comprobar que si a un diccionario que existe le pregunto si existe un término que no existe, me diga: que NO
    PRUEBA -> CASOS DE PRUEBA.... multitud de datos manana , 33333 , $%&/2manzana

    String idioma = "ES";
    Diccionario dicEspanol = SuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
    dicEspanol.existe("MORDOR") // ASSERT: FALSE

// Comprobar que si a un diccionario que existe le pido las definiciones de un término que existe me son devueltas.

    String idioma = "ES";
    Diccionario dicEspanol = SuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
    String terminoQueExiste = "Manzana";
    dicEspanol.getDefiniciones(terminoQueExiste) // Assert Que la lista sea devuelta

// Comprobar que si a un diccionario que existe le pido las definiciones de un término que no existe, nome son devueltas.

    String idioma = "ES";
    Diccionario dicEspanol = SuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
    String terminoQueNOExiste = "FELIPON!!!!";
    dicEspanol.getDefiniciones(terminoQueNOExiste)  // Assert Que la lista no sea devuelta

// Comprobar que si a un diccionario que existe le pido las sugerencias de un término que no existe me son devueltas.

    
}
