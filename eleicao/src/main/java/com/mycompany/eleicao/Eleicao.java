package com.mycompany.eleicao;
import java.util.Scanner;

public class Eleicao {

    public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int idade;
      idade = teclado.nextInt();
      
        
            if(idade<16){
                System.out.println("Voce nao possui idade para votar");
            }
            if(16<=idade && idade<18){
             System.out.println("O seu voto eh opcional");
            }
            if(18<=idade && idade<=70){
                System.out.println("O seu voto eh obrigatorio"); 
            }
            if(idade>70){
                System.out.println("O seu voto eh opcional");
            }
        
    }
}
