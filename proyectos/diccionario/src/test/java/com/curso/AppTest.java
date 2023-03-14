package com.curso;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.params.ParametrizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AppTest {
    
    private this.miSuministradorDeDiccionarios mithis.miSuministradorDeDiccionarios;
    
    @BeforeAll
    //@AfterAll
    //@BeforeEach
    //@AfterEach
    public void obtenerthis.miSuministradorDeDiccionarios(){
        this.mithis.miSuministradorDeDiccionarios = this.miSuministradorDeDiccionariosFactory.getInstance();
    }

    // Comprobar que si pido un diccionario en un idioma existente, el diccionario es devuelto
    // Servicio? JAVA 9 -> ServiceLoader.loadService(this.miSuministradorDeDiccionarios.class)
    @Test    
    public void obtenerDiccionarioValido(){
        String idioma = "ES";
        Optional<Diccionario> dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma);
        Assertions.assertTrue(dicEspanol.isPresent()); // Assert? dicEspanol no venga vacio (venga relleno)
        Assertions.assertEquals(idioma , dicEspanol.orElseThrow().getIdioma());
    }

    // Comprobar que si pido un diccionario en un idioma que no existente, no se devuelve un diccionario
    @Test    
    public void obtenerDiccionarioNoValido(){
        String idioma = "DE LOS ELFOS";
        Optional<Diccionario> dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma);
        Assertions.assertTrue(dicEspanol.isEmpty()); 
    }

    // Comprobar que si pregunto si existe un diccionario en un idioma existente, me digan que SI
    @Test    
    public void existeDiccionarioValido(){
        String idioma = "ES";
        boolean existe = this.miSuministradorDeDiccionarios.tienesDiccionarioDe(idioma);
        Assertions.assertTrue(existe); // Assert -> TRUE
    }
    

    // Comprobar que si pregunto si existe un diccionario en un idioma que no existente, me digan que NO
    @Test    
    public void existeDiccionarioNoValido(){
        String idioma = "DE LOS ELFOS";
        boolean existe = this.miSuministradorDeDiccionarios.tienesDiccionarioDe(idioma);
        Assertions.assertFalse(existe); //  Assert -> FALSE
    }
    
    // Comprobar que si a un diccionario que existe le pregunto si existe un término que existe, me diga: que SI
    //PRUEBA -> CASOS DE PRUEBA.... multitud de datos manzana, PERRO, perro, Perro, peRRO
    @ParametrizedTest
    @ValueSource(strings= {"MANZANA", "MAnzana", "manzana", "perro", "PERRO", "Perro"})
    public void asegurarTerminosExisten(String termino){
        String idioma = "ES";
        Diccionario dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
        Assertions.assertTrue(dicEspanol.existe(termino)); // ASSERT: TRUE
    }
    
    // Comprobar que si a un diccionario que existe le pregunto si existe un término que no existe, me diga: que NO
    // PRUEBA -> CASOS DE PRUEBA.... multitud de datos manana , 33333 , $%&/2manzana
    @ParametrizedTest
    @ValueSource(strings= {"manana", "33333", "$%&/2manzana"})
    public void asegurarTerminosNoExisten(String termino){
        String idioma = "ES";
        Diccionario dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
        Assertions.assertFalse(dicEspanol.existe(termino)); // ASSERT: FALSE
    }
    // Comprobar que si a un diccionario que existe le pido las definiciones de un término que existe me son devueltas.
    @ParametrizedTest
    @CsvSource({"MANZANA,1,Fruto del manzano", "perro,2,Animal de compañía"})
    public void definicionesTerminosExisten(String terminoQueExiste, int numeroDefiniciones, String primeraDefinicion){
        String idioma = "ES";
        Diccionario dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
        Assertions.assertTrue(dicEspanol.getDefiniciones(terminoQueExiste).isPresent()); // Assert Que la lista sea devuelta
        
        List<String> definiciones = dicEspanol.getDefiniciones(terminoQueExiste).orElseThrow();
        Assertions.assertEquals(numeroDefiniciones, definiciones.size());
        Assertions.assertEquals(primeraDefinicion, definiciones.get(0));
        //??? 
    }
    
    // Comprobar que si a un diccionario que existe le pido las definiciones de un término que existe me son devueltas.
    @ParametrizedTest
    @CsvFileSource(resources="/terminos_con_definiciones.csv", numLinesToSkip=1 )
    public void definicionesTerminosExisten2(String terminoQueExiste, int numeroDefiniciones, String primeraDefinicion){
        String idioma = "ES";
        Diccionario dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
        Assertions.assertTrue(dicEspanol.getDefiniciones(terminoQueExiste).isPresent()); // Assert Que la lista sea devuelta
        
        List<String> definiciones = dicEspanol.getDefiniciones(terminoQueExiste).orElseThrow();
        Assertions.assertEquals(numeroDefiniciones, definiciones.size());
        Assertions.assertEquals(primeraDefinicion, definiciones.get(0));
        //??? 
    }
    
    // Comprobar que si a un diccionario que existe le pido las definiciones de un término que no existe, nome son devueltas.
    @ParametrizedTest
    @ValueSource(strings= {"manana", "33333", "$%&/2manzana"})
    public void definicionesTerminosNoExisten(String terminoQueNOExiste){
        String idioma = "ES";
        Diccionario dicEspanol = this.miSuministradorDeDiccionarios.getDiccionario(idioma).orElseThrow();
        Assertions.assertTrue(dicEspanol.getDefiniciones(terminoQueNOExiste).isEmpty());  // Assert Que la lista no sea devuelta
    }
    // Comprobar que si a un diccionario que existe le pido las sugerencias de un término que no existe me son devueltas.

    
}
