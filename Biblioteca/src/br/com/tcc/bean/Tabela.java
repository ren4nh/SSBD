package br.com.tcc.bean;

import java.util.ArrayList;
import java.util.List;

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
    public String toString() {
        return "Tabela{" + "nome=" + nome + '}';
    }
    
    
    
}
