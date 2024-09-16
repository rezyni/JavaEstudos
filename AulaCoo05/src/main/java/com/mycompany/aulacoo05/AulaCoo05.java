package com.mycompany.aulacoo05;
 // ** @author Caique
import java.util.Scanner;

public class AulaCoo05 {

    public static void main(String[] args) {
        /*   ***Funcoes***
        abrirConta()
        fecharConta()
        depositar()
        sacar()
        pagarMensal()
            ***Fim das Funcoes***
        */
        Scanner teclado = new Scanner(System.in);
        
        ContaCorrente c1 = new ContaCorrente();
        
        System.out.println("para abrir a sua conta digite 1\ndepositar digite 2\n"
                         + "sacar digite 3\npagar mensalidade 4\nver o status 5\n"
                         + "fechar conta 6\nsair 7 ");
        int acao = teclado.nextInt();
        while(acao != 7){
            
            if(acao == 1){
                c1.abrirConta("caique");
                acao =0;
            }
            if(acao == 2){
                c1.depositar();
                acao =0;
            }
            if(acao == 3){
                c1.sacar();
                acao =0;
            }
            if(acao == 4){
                c1.pagarMensal();
                acao =0;
            }
            if(acao == 5){
                c1.status();
                acao =0;
            }
            if(acao == 6){
                c1.fecharConta();
                acao = 0;
            }
            System.out.println("para abrir a sua conta digite 1\ndepositar digite 2\n"
                         + "sacar digite 3\npagar mensalidade 4\nver o status 5\n"
                         + "fechar conta 6\nsair 7 ");
            acao = teclado.nextInt();          
        }
               
        
        
    }
}
