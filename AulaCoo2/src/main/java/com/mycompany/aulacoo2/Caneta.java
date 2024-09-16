package com.mycompany.aulacoo2;

public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tampada;
    
    public void status(){
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Com "+this.carga+"% de tinta");
        System.out.println("Que esta tampada? " + this.tampada+"\n");
        
    }
    
     
    protected void rabiscar(){
        if(this.tampada == true){
            System.out.println("nao e possivel rabiscar com a caneta tampada\n");
        }
        else{
            System.out.println("estou rabiscando \n");
        }
    }
    
    public void tampar(){
        this.tampada = true;
    }
    
    public void destampar(){
        this.tampada = false;
    }
            
    
}
