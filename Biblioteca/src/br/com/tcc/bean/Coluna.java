package br.com.tcc.bean;

/**
 *
 * @author renan
 */
public class Coluna {

    private String nome;
    private String tipo;
    private int tamanho;
    private String nulo;
    private int casas;
    private boolean pk;
    private boolean fk;

    public Coluna() {
    }

    public int getCasas() {
        return casas;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNulo() {
        return nulo;
    }

    public void setNulo(String nulo) {
        this.nulo = nulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public boolean isFk() {
        return fk;
    }

    public void setFk(boolean fk) {
        this.fk = fk;
    }
}
