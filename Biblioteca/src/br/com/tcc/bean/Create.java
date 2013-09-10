package br.com.tcc.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author renan
 */
public class Create {

    @XStreamAlias("tabelas")
    private List<Tabela> listaTabela;

    public Create() {
    }

    public List<Tabela> getListaTabela() {
        return listaTabela;
    }

    public void setListaTabela(List<Tabela> listaTabela) {
        this.listaTabela = listaTabela;
    }
}
