package br.com.tcc.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class Conexao {

    private String nome;
    private List<Tabela> listaTabelas = new ArrayList<>();

    public Conexao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Tabela> getListaTabelas() {
        return listaTabelas;
    }

    public void setListaTabelas(List<Tabela> listaTabelas) {
        this.listaTabelas = listaTabelas;
    }
}
