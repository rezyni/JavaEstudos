package com.mycompany.aulacoo2;

public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;
    
    void status(){
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Com "+this.carga+"% de tinta");
        System.out.println("Que esta tampada? " + this.tampada+"\n");
        
    }
    
     
    void rabiscar(){
        if(this.tampada == true){
            System.out.println("nao e possivel rabiscar com a caneta tampada\n");
        }
        else{
            System.out.println("estou rabiscando \n");
        }
    }
    
    void tampar(){
        this.tampada = true;
    }
    
    void destampar(){
        this.tampada = false;
    }
            
    
}
