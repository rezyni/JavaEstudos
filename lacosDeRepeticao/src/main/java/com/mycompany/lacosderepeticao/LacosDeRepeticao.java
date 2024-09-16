package com.mycompany.lacosderepeticao;
import java.util.Scanner;

public class LacosDeRepeticao {

    public static void main(String[] args) {
      /*Scanner teclado = new Scanner(System.in);
        int cambalhota = teclado.nextInt();
      */
      int cambalhota = 0;
        
      /*  while(cambalhota<10){
            cambalhota++;
            if(cambalhota == 5||cambalhota == 7){ 
                continue;
            }
            if(cambalhota == 8){
                break;
            }
            System.out.println(+cambalhota);
            
            }
      */
        do{
            cambalhota++;
            System.out.println(+cambalhota);
        }
        while(cambalhota<4);
      
        
    }
}
