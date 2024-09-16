package com.mycompany.pessoa;

/**
 *
 * @author Caique
 */
public class Pessoa {
    private String nome;
    private int idade;
    private String sexo; // M para masculino, F para feminino
    
    public Pessoa(String nome, int idade, String sexo){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void fazerAniver(){
        setIdade(getIdade()+1);
    }
     public static void main(String[] args) {
        Pessoa[] p = new Pessoa[2];
        Livro[] l = new Livro[3];
        
        p[0] = new Pessoa("Pedro",22,"M");
        p[1] = new Pessoa("Maria",25,"F");
        
        //String t, String a, int pag, Pessoa l
        
        l[0] = new Livro("Aprendendo Java", "Jose da silva",300,p[0]);
        l[1] = new Livro("POO para iniciantes", "Pedro Paulo",250,p[1]);
        l[2] = new Livro("Java Avancado", "Maria Candido",800,p[0]);
        
        
        l[0].detalhes();
        
        l[0].abrir();
        l[0].folhear(200);
        l[0].avancarPag();
        l[0].detalhes();
    }
    
}
