package br.com.tcc.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author renan
 */
public class Tabela {

    private String nome;
    @XStreamAlias("colunas")
    private List<Coluna> listaColuna = new ArrayList<>();
    private PrimaryKey pk;
    @XStreamAlias("fks")
    private List<ForeignKey> listaFk = new ArrayList<>();

    public Tabela() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Coluna> getListaColuna() {
        return listaColuna;
    }

    public void setListaColuna(List<Coluna> listaColuna) {
        this.listaColuna = listaColuna;
    }

    public PrimaryKey getPk() {
        return pk;
    }

    public void setPk(PrimaryKey pk) {
        this.pk = pk;
    }

    public List<ForeignKey> getListaFk() {
        return listaFk;
    }

    public void setListaFk(List<ForeignKey> listaFk) {
        this.listaFk = listaFk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Tabela other = (Tabela) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tabela{" + "nome=" + nome + '}';
    }
}
