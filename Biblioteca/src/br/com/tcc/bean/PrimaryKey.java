package br.com.tcc.bean;

/**
 *
 * @author renan
 */
public class PrimaryKey {

    private String nome;
    private String coluna;

    public PrimaryKey() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }
}
