package br.com.tcc.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.List;

/**
 *
 * @author renan
 */
public class Delete {

    @XStreamAlias("tabelas")
    private List<Tabela> listaTabelas;

    public Delete() {
    }

    public List<Tabela> getListaTabelas() {
        return listaTabelas;
    }

    public void setListaTabelas(List<Tabela> listaTabelas) {
        this.listaTabelas = listaTabelas;
    }
}
