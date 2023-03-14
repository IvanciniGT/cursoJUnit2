package com.curso;

public class App {
    
    public static void main( String[] args ) {
        
        Contador c1 = new Contador("Contador1");
        System.out.println( c1.getNombre() );
        System.out.println( c1.getNumero() );
        c1.incrementarNumero();
        System.out.println( c1.getNumero() );
        
    }
    
}
