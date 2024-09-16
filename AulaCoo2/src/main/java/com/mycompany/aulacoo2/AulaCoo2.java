package com.mycompany.aulacoo2;


public class AulaCoo2 {

    public static void main(String[] args) {
       Caneta c1 = new Caneta();
       c1.modelo = "Bic Cristal";
       c1.cor = "vermelho";
       //c1.ponta = 0.5f;
       c1.carga = 80;
       //c1.tampada = false;
       c1.destampar();
       c1.status();
       c1.rabiscar();
       
    }
}
