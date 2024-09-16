/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polimorfismo;

/**
 *
 * @author Caique
 */
public class Peixe extends Animal{
    
    private String corEscama;

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }
    
    @Override
    public void locomover(){
        System.out.println("Nadando");
    }
    @Override
    public void alimentar(){
        System.out.println("Comendo substancias");
    }
    @Override
    public void emitirSom(){
        System.out.println("peixe não faz som");
    }
    
    
    public void soltarBolha(){
        System.out.println("Soltou uma bolha");
    }
}
