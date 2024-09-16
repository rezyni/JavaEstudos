/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.polimorfismo;

/**
 *
 * @author Caique
 */
public class Reptil extends Animal {
    
    private String corEescama;

    public String getCorEscama() {
        return corEescama;
    }

    public void setCorEescama(String corEescama) {
        this.corEescama = corEescama;
        
    }
    
    @Override
    public void status(){
        
        System.out.println("peso: "+getPeso());
        System.out.println("idade: "+getIdade());
        System.out.println("peso: "+getMembros());
        System.out.println(getCorEscama());
        System.out.println("");
    }
    
    @Override
    public void locomover(){
        System.out.println("Rastejando");
    }
    
    @Override
    public void alimentar(){
        System.out.println("Comendo Vegetais");
    }
    
    @Override
    public void emitirSom(){
        System.out.println("som de Reptil");
    }
    
}
