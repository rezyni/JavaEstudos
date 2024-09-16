package com.mycompany.aulaheranca;

/*
 * @author Caique
 */
public class AulaHeranca {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Aluno p2 = new Aluno();
        Professor p3 = new Professor();
        Funcionario p4 = new Funcionario();
        
        p1.setNome("Pedro");
        p2.setNome("Maria");
        p3.setNome("Claudio");
        p4.setNome("Fabiana");
        
        p2.setCurso("Informática");
        
        p2.status();
        
    }
    
    
}
