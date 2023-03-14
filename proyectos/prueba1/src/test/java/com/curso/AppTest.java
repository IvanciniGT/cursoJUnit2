package com.curso;

// import static org.junit.Assert.assertEquals; 
// Importar una función estática y usarla como si fuera mia

import org.junit.Assert;

import org.junit.Test;

public class AppTest {
    
    // Que incremente bien
    
    @Test
    public void pruebaDelConstructor() {
        String valorEsperado = "Federico";
        Contador c1=new Contador(valorEsperado);
        
        String valorDevuelto = c1.getNombre();
        Assert.assertEquals(valorEsperado, valorDevuelto);
        
        int numeroEsperado = 0;
        int numeroDevuelto = c1.getNumero();
        Assert.assertEquals(numeroEsperado, numeroDevuelto);
    }
    
    @Test
    public void pruebaDeIncrementar() {
        int valorEsperado = 1;
        Contador c1=new Contador("Federico");
        c1.incrementarNumero();
        int valorDevuelto = c1.getNumero();
        // Que puedo recuperar bien el numero... despues de incrementarlo
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }    
    
    @Test
    public void pruebaDeDecrementar() {
        int valorEsperado = -1;
        Contador c1=new Contador("Federico");
        c1.decrementarNumero();
        int valorDevuelto = c1.getNumero();
        // Que puedo recuperar bien el numero... despues de incrementarlo
        Assert.assertEquals(valorEsperado, valorDevuelto);
    }    
    
}
