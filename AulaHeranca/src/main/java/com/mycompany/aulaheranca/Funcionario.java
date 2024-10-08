package com.mycompany.aulaheranca;

/**
 * @author Caique
 */

/*
    Abstract não pode ser instanciado em outra classe (eu acho)
*/
public class Funcionario extends Pessoa {
    private String setor;
    private boolean trabalhando;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean getTrabalhando() {
        return trabalhando;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }
    
    public void mudarTrabalho(){
        this.trabalhando=!this.trabalhando;
    }
}
