package com.mycompany.controleremoto;

/**
 *
 * @author Caique
 */
public class FuncoesControle implements Controlador{
    
    private int volume;
    private int volume_salvo; // utilizando para auxilio 
    private boolean volume_mutado; // utilizado para auxilio tambem 
    private boolean ligado;
    private boolean tocando;
    
    public FuncoesControle(){
        setvolume(50);
        setligado(false);
        this.tocando = false;
    }
    
    
    //getters e setters
    private int getvolume(){
        return this.volume;
    }
    private void setvolume(int v){
        this.volume = v;
    }
    
    private int getvolume_salvo(){
        return this.volume_salvo;
    }
    private void setvolume_salvo(int vs){
        this.volume_salvo = vs;
    }
    
    private boolean getvolume_mutado(){
        return this.volume_mutado;
    }
     private void setvolume_mutado(boolean vm){
        this.volume_mutado = vm;
     }
    
    private boolean getligado(){
        return this.ligado;
    }
    private void setligado(boolean l){
        this.ligado = l;
    }
    
    private boolean gettocando(){
        return this.tocando;
    }
    private void settocando(boolean t){
        this.tocando = t;
    }
    
    
    //<<interface>>
    @Override
    public void ligar(){
        this.setligado(true);
    } 
    @Override
    public void desligar(){
        this.setligado(false);
    }
    
    @Override
    public void abrirMenu(){
        System.out.println("Esta ligado? "+ this.getligado());
        System.out.println("Esta tocando? "+this.gettocando());
        System.out.print("Volume: "+this.getvolume());
        for (int i =0; i<=this.getvolume();i+=10){
            System.out.print("*­");
        }
    } 
    @Override
    public void fecharMenu(){
        System.out.println("----Fechando menu----");
    }
    
    @Override
    public void maisVolume(){
        if (this.getligado() == true){
            if(this.getvolume_mutado() == true){
                this.setvolume(this.getvolume_salvo());
            }
           this.setvolume(this.getvolume()+5);
        }
    }   
    @Override
    public void menosVolume(){
        if (this.getligado() == true){
            if(this.getvolume_mutado() == true){
                this.setvolume(this.getvolume_salvo());
            }
            this.setvolume(this.getvolume()-5);
        }
    }
    
    @Override
    public void ligarMudo(){
        if (this.getligado() == true){
            while(this.getvolume_mutado() != true){
                this.setvolume_mutado(true);
                this.setvolume_salvo(this.getvolume());
                this.setvolume(0);
            }
        }
    }
    
    @Override
    public void play(){
        if (this.getligado() && !(this.gettocando())){
            this.settocando(true);
        }
    }  
    @Override
    public void pause(){
        if (this.getligado()&& this.gettocando()){
            this.settocando(false);
        }
    }

}
