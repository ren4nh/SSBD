package br.com.tcc.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author renan
 */
public class Tabela {

    private String nome;
    private List<Coluna> listaColuna = new ArrayList<>();

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
