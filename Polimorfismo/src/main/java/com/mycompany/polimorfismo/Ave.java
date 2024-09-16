package com.mycompany.polimorfismo;

/*
 * @author Caique
 */
public class Ave extends Animal {
    
    private String corPena;

    public String getCorPena() {
        return corPena;
    }

    public void setCorPena(String corPena) {
        this.corPena = corPena;
    }

    @Override
    public void locomover() {
        System.out.println("Voando");
    }
    @Override
    public void alimentar() {
        System.out.println("Comendo frutas"); 
    }
    @Override
    public void emitirSom() {
        System.out.println("Som de Ave");
    }
    
    
    public void construirNinho(){
        System.out.println("Foi construido um ninho");
    }
}
