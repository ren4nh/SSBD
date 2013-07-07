package br.com.tcc.bean;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class Conexao {

    private String nome;
    private Connection conexao;
    private List<Tabela> listaTabelas = new ArrayList<>();

    public Conexao() {
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
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

    @Override
    public String toString() {
        return nome;
    }
}
