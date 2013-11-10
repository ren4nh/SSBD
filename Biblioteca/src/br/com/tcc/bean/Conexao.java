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
    private String senha;
    private String servidor;
    private String base;
    private String porta;
    private String user;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return nome;
    }
}
