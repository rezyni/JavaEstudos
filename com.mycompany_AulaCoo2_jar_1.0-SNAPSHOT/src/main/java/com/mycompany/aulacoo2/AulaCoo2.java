package com.mycompany.aulacoo2;


public class AulaCoo2 {

    public static void main(String[] args) {
       Caneta c1 = new Caneta();
       c1.modelo = "caneta ponta fina";
       c1.cor = "Azul";
       c1.ponta = 0.5f;
       c1.tampada = false;
       c1.carga = 85;
       
       c1.tampar();       
       c1.status();
       c1.rabiscar();
       c1.destampar();
       c1.status();
       c1.rabiscar();
       
       Caneta c2 = new Caneta();
       c2.modelo = "caneta ponta grossa";
       c2.cor = "Preta";
       c2.ponta = 1.0f;
       c2.tampada = false;
       c2.carga = 95;
       
       c2.destampar();
       c2.status();
       c2.rabiscar();
    }
}
