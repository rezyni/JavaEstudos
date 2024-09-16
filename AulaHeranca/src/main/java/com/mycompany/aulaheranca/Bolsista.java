/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aulaheranca;

/**
 *
 * @author Caique
 */
public class Bolsista extends Aluno {
    private int bolsa;

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }
    
    public void RenovarBolsa(){
        System.out.println("Renovando bolsa de: "+ getNome());
    }
    
    @Override
    public void pagarMensalidade(){
        System.out.println("mensalidade paga de um bolsista");
    }
}
