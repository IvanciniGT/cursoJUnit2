package com.curso;

public class Contador {
    
    private String nombre;
    
    private int numero;
    
    public Contador(String nombre){
        this.nombre = nombre;
        this.numero = 0;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void incrementarNumero(){
        this.numero++;
    }
    
    public void decrementarNumero(){
        this.numero--;
    }
    
}