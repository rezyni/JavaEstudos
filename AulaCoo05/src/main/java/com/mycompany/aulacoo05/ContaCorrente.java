
package com.mycompany.aulacoo05;
import java.util.Scanner;

public class ContaCorrente {
    
    Scanner teclado = new Scanner(System.in);
    
    public int numConta;
    protected String tipoConta;
    private String donoConta;
    private float saldoConta;
    private String statusConta;
    
    private String confirma;
    
    public ContaCorrente(){
        this.statusConta = "INATIVA";
        this.saldoConta = 0;
    
    }
    
    //Getters e Setters
    public int getnumConta(){
        return this.numConta;
    } 
    public void setnumConta(int n){
        this.numConta = n;
    }
    
    public String gettipoConta(){
        return this.tipoConta;
    }
    public void settipoConta(String t){
        this.tipoConta = t;
    }
    
    public String getdonoConta(){
        return this.donoConta;
    }
    public void setdonoConta(String d){
        this.donoConta = d;
    }
    
    public float getsaldoConta(){
        return this.saldoConta;
    }
    public void setsaldoConta(float s){
        this.saldoConta =  s;
    }
    public String getstatusConta(){
        return this.statusConta;
    }
    
    //Fim Getters e Setters
    
    
    public void status(){
        System.out.println("SOBRE A CONTA:");
        System.out.println("num da conta:"+getnumConta());
        System.out.println("tipo da conta:"+gettipoConta());
        System.out.println("dono(a) da conta:"+getdonoConta());
        System.out.println("saldo da conta:"+getsaldoConta());
        System.out.println("a conta esta com status:"+getstatusConta());
    }
    
    public void abrirConta(String n){
        this.donoConta = n;
        this.statusConta = "ATIVA";
        this.saldoConta = 0;
        System.out.println("qual tipo de conta você deseja abrir, corrente (digite CC) ou poupanca (digite CP)?");
        this.tipoConta = teclado.nextLine();
        
        if("CC".equals(this.tipoConta)){
            this.setsaldoConta(50);
        }
        else{
            this.setsaldoConta(150);
        }
        
        System.out.println("conta criada com sucesso");
        
    }
    
    public void fecharConta(){
        System.out.println("Voce confirma a exclusao da conta de numero: "+this.numConta+
                            " do dono(a): "+donoConta+"?"+
                            " se sim, digite SIM, caso nao, digite NAO");
        
        this.confirma = teclado.nextLine();
        
        if("SIM".equals(this.confirma)){
            this.statusConta = "INATIVA";
            System.out.println("conta inativa");
        }
        else{
            System.out.println("sua conta ainda esta ativa");
        }
        
    }
    
    public void depositar(){
        if("ATIVA".equals(this.statusConta)){
            System.out.println("sua conta possui: R$"+this.saldoConta);
            System.out.print("insira o valor que voce deseja depositar: ");
            this.saldoConta = this.saldoConta + teclado.nextFloat();
            System.out.println("o novo valor da sua conta eh de: "+this.saldoConta);
        }
        else{
            System.out.println("Essa conta esta"+this.statusConta);
        }
    }
    
    public void sacar(){
        if("ATIVA".equals(this.statusConta)){
            System.out.println("sua conta possui: R$"+this.saldoConta);
            System.out.print("insira o valor que voce deseja sacar: ");
            this.saldoConta = this.saldoConta - teclado.nextFloat();
            System.out.println("o novo valor da sua conta eh de: "+this.saldoConta);
        }
        else{
            System.out.println("Essa conta esta"+this.statusConta);
        }
    }
    
    public void pagarMensal(){
        if("ATIVA".equals(this.statusConta)){
            if("CC".equals(tipoConta)){
                this.saldoConta = this.saldoConta - 12f;
                System.out.println("o novo valor da sua conta eh de: "+this.saldoConta);
            }if("CP".equals(tipoConta)){
                this.saldoConta = this.saldoConta - 20f;
                System.out.println("o novo valor da sua conta eh de: "+this.saldoConta);
            }
        }
        else{
            System.out.println("Essa conta esta"+this.statusConta);
        }
    }
    
    
}
