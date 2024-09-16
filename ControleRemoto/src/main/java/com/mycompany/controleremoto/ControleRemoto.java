/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controleremoto;

/**
 *
 * @author Caique
 */
public class ControleRemoto {

    public static void main(String[] args) {
        /*funcoes do controle
        <<interface>>
        ligar()
        desligar()
        abrirMenu()
        fecharMenu()
        maisVolume()
        menosVolume()
        ligarMudo()
        desligarMudo()
        play()
        pause()
        */
        
        FuncoesControle c1 = new FuncoesControle();
        c1.ligar();
        c1.maisVolume();
        c1.ligarMudo();
        c1.abrirMenu();
        c1.fecharMenu();
        c1.maisVolume();
        c1.abrirMenu();
    }
}
