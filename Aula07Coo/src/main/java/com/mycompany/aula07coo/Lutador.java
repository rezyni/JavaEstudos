package com.mycompany.aula07coo;
public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Lutador(String no, String na, int id, float al, float pe, int vi, 
                    int de, int em){
        this.nome = no;
        this.nacionalidade = na;
        this.idade = id;
        this.altura = al;
        this.setPeso(pe);
        this.vitorias = vi;
        this.derrotas = de;
        this.empates = em;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria() {
        if (getPeso()<52.2){
           this.categoria = "Invalido";
        }else if(getPeso()<=70.3){
            this.categoria ="Leve";
        }else if(getPeso()<=83.9){
            this.categoria ="Medio";
        }else if(getPeso()<=120.2){
            this.categoria ="Pesado";
        }else{
            this.categoria="Invalido";
        }
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
    
  
    public void apresentar(){
        System.out.println("Lutador: "+getNome());
        System.out.println("Origem: "+getNacionalidade());
        System.out.println(getIdade()+" anos");
        System.out.println(getAltura()+"m de altura");
        System.out.println("Pesando: "+getPeso()+"Kg");
        System.out.println("Ganhou: "+getVitorias());
        System.out.println("perdeu: "+getDerrotas());
        System.out.println("Empatou: "+getEmpates());
        System.out.println("");
    }
    
    public void status(){
        System.out.println(getNome());
        System.out.println("e um peso "+getCategoria());
        System.out.println(getVitorias()+" vitorias");
        System.out.println(getDerrotas()+" derrotas");
        System.out.println(getEmpates()+" empates");
    }
    
    public void ganharLuta(){
        this.setVitorias(this.getVitorias()+1);
    }
    
    public void perderLuta(){
        this.setDerrotas(this.getDerrotas()+1);
    }
    
    public void empatarLuta(){
        setEmpates(this.getEmpates()+1);
    }
    
}
