package com.mycompany.pernas;
import java.util.Scanner;


public class Pernas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int pernas = teclado.nextInt();
        String tipo;
        switch(pernas){
            case 1:
                tipo = "Saci";
                break;
            case 2:
                tipo = "Bipede";
                break;    
            case 4:
                tipo = "Quadrupede";
                break;
            case 6,8:
                tipo = "Aracnideo";
                break;
            default:
                tipo = "ET";
        }
        System.out.println(tipo);
    }
}
