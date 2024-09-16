/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.operadoresaritmeticos;
 

/**
 *
 * @author Caique
 */
public class OperadoresAritmeticos {

    public static void main(String[] args) {
    /*  int n1 = 3;
        int n2 = 5;
        float m = (n1+n2)/2;
       // System.out.println("A media e igual a"+m);
        int n3 = (int)Math.pow(n1,n2);
       // System.out.println("a eleveação de"+n1 +"por" +n2 +"eh igual a: "+n3);
    */   
       
       //OPERADORES TERNARIOS;
    
    /*  int n1, n2, r;
      n1 = 14;
      n2 = 8;
      r = (n1>n2)?n1:n2;
      System.out.println(r);
    */  
        
        String n1 = "Gustavo";
        String n2 = "Gustavo"; 
        String n3 = new String("Gustavo");
        String res, res2;
        res = (n1==n2)?"igual":"diferente";
        System.out.println(res);
        res2 = (n1.equals(n3))?"ingualzin":"diferentin";
        System.out.println(res2);
    }
}
