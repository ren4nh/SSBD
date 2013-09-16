package br.com.tcc.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class Alter {

    private String acao;
    @XStreamAlias("tabelas")
    private List<Tabela> listaTabela = new ArrayList<>();

    public Alter() {
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public List<Tabela> getListaTabela() {
        return listaTabela;
    }

    public void setListaTabela(List<Tabela> listaTabela) {
        this.listaTabela = listaTabela;
    }
}
