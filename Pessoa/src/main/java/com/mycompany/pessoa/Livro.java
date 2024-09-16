package com.mycompany.pessoa;
/*
 * @author Caique
 */
public class Livro implements Publicacao{
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;
    
    public Livro(String t, String a, int pag, Pessoa l){
        this.titulo = t;
        this.autor = a;
        this.totPaginas = pag;
        this.leitor = l;
        this.pagAtual = 0;
        this.aberto = false;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTitulo(String t){
        this.titulo = t;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

   
    
    public void detalhes(){
        System.out.println("Livro: "+getTitulo());
        System.out.println("Autor: "+getAutor());
        System.out.println("Quantidade de Paginas: "+getTotPaginas());
        System.out.println("Pagina atual: "+getPagAtual());
        System.out.println("O livro esta aberto?: "+((getAberto()) ? "Aberto":"fechado"));
        System.out.println("Leitor: "+leitor.getNome());
        System.out.println("Idade: "+leitor.getIdade());
        System.out.println("Sexo: "+leitor.getSexo());
        System.out.println("");
    }

    @Override
    public void abrir() {
        setAberto(true);
    }

    @Override
    public void fechar() {
        setAberto(false);
    }

    @Override
    public void folhear(int p) {
        setPagAtual(p);
    }

    @Override
    public void avancarPag() {
        setPagAtual(getPagAtual()+1);
    }

    @Override
    public void voltarPag() {
        setPagAtual(getPagAtual()-1);
    }
    
    
    
}
