/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vetores;

import java.util.Arrays;

/**
 *
 * @author Caique
 */
public class Vetores {

    public static void main(String[] args) {
        /* int n[] = new int[4];*/
        int n[] = {1,4,5,7};
         /*
         da para fazder da maneira convencional
         n[0] = 3;
         ...
         
         também da para fazer assim:
         
         int n[] ={3,5,8,2,7};  (declarando o valor diretamente
                                sem precisar da linha 14)
         */
         
        for(int i=0; i<n.length;i++){
             System.out.println(n[i]);
        }
         
        String mes[] = {"jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov","dez"};
        for(int i=0; i<mes.length;i++){
            System.out.println(mes[i]);
        }
        
        double v[] = {3.5, 2.75, 9, -4.5};
        Arrays.sort(v);//código para ordenar o array;
        for(double valor:v){   //maneira de correr o vetor diferente
            System.out.print(valor+" ");
        }
        int pos = Arrays.binarySearch(v, 3.5); //realiza a busca binaria
        
        System.out.println("na posicao["+pos+"] esta o valor buscado:"+v[pos]);
        
        Arrays.fill(v,0); //preencher todos os índices de um vetor com um determinado valor
        for(double valor: v){
            System.out.println(valor);
        }
    }
}
