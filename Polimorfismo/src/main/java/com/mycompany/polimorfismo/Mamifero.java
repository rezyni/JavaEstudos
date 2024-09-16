/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polimorfismo;

/**
 *
 * @author Caique
 */
public class Mamifero extends Animal{

    private String corPelo;
    
    public String getCorPelo(){
        return this.corPelo;
    }
    public void setCorPelo(String n){
        this.corPelo = n;
    }
   
    
    @Override
    public void locomover() {
        System.out.println("Correndo");
    }

    @Override
    public void alimentar() {
        System.out.println("Mamando");
    }

    @Override
    public void emitirSom() {
        System.out.println("som de Mamífero");
    }
    
}
