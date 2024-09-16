package com.mycompany.rotina;



public class Rotina {
    
    static void soma(int a , int b){
        int s = a+b;
        System.out.println(s);
    }
    
    static int somas(int a,int b){
        int s = a+b;
        return s;    
    }

    public static void main(String[] args) {
        soma(5,7);
        int sm = somas(5,10);
        System.out.println(sm);
    }
}

