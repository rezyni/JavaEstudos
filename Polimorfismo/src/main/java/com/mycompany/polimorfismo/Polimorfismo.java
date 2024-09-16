package com.mycompany.polimorfismo;

/*
 * @author Caique
 */
public class Polimorfismo {

    public static void main(String[] args) {
        //Animal n = new Animal(); não funciona pq ele é abstrato
        Reptil r = new Reptil();
        
        r.setPeso(85.3f);
        r.setIdade(2);
        r.setMembros(0);
        r.status();
        r.locomover();
        r.alimentar();
        r.emitirSom();
        
        Peixe p = new Peixe();
        
        p.setPeso(5.3f);
        p.setIdade(1);
        p.setMembros(0);
        p.status();
        p.locomover();
        p.alimentar();
        p.emitirSom();
        
    }
}
