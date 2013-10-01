package br.com.tcc.bean;

import java.util.Objects;

/**
 *
 * @author renan
 */
public class Coluna {

    private String nome;
    private String acao;
    private String tipo;
    private String tamanho;
    private String nulo;
    private String casas;
    private String pk;
    private ForeignKey fk;

    public Coluna() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCasas() {
        return casas;
    }

    public void setCasas(String casas) {
        this.casas = casas;
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

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public ForeignKey getFk() {
        return fk;
    }

    public void setFk(ForeignKey fk) {
        this.fk = fk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coluna other = (Coluna) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
