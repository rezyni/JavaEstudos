package com.mycompany.agoravai; //pacote sempre com letra minúscula

import java.util.Date;
import java.util.Locale;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.util.Scanner;


public class Agoravai { //Classe sempre possui a primeira letra maíuscula 

   
    /*int idade = 3;
    float sal = 1825.54f;
    char letra = 'g';
    boolean casado = false;
    
    int idadet = (int) 3; //utilizando o typecast
    float salt = (float) 1825.54;
    char letrat = (char)'g';
    boolean casadot = (boolean) true;
    
    Integer idadec = new Integer (3); //objeto o new sempre está criando um ojbeto
    Float salc = new Float(1825.54);
    Character letrac = new Character('g');
    Boolean casadoc = new Boolean(false);
    */
    
    public static void main(String[] args) {//Variáveis, atributos e métodos 
                                            //em letra minúscula com maíscula dps
                                            //exemplo: nomeAluno
                                            
                                            //Todas maíusculas é constante
       /* Date relogio = new Date();
        System.out.print("Data e hora : ");
        System.out.println(relogio.toString());
        
        Locale loc = Locale.getDefault();
        System.out.print("O idioma do sistema eh : ");
        System.out.println(loc.getDisplayLanguage()); //Imprime o idioma
        
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        System.out.println("A resolucao do seu sistema eh : " +d.width+"X"+d.height);
       */
       
       /*Scanner teclado = new Scanner(System.in);
       float nota = 8.576f;
       System.out.print("Digite o nome do aluno:");
       String nome = teclado.nextLine();
       System.out.print("Digite a nota do aluno:");
       float nota1 = teclado.nextFloat();
       System.out.println("nota :"+nota);
       System.out.printf("A nota do(a) %s eh: % .2f ",nome,nota1);
       System.out.format("A nota do(a) %s eh: % .2f ",nome,nota);
       */
       
       
       
       
      /* int idade = 30;
       //não funciona: String valor = idade;
       String valor = Integer.toString(idade);
       System.out.println(valor);
     */
      
      String valor = "30";
      int idade = Integer.parseInt(valor);
      System.out.println(+idade);
      
    }
    
}
