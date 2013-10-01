package br.com.tcc.service;

import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.Tabela;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class ComparaConstraints {

    private boolean iguais = false;

    public Auxiliar comparaPk(Tabela tabelaAtual, Tabela tabelaAntiga) {
        if (tabelaAntiga.getPk() != null) {
            if (tabelaAtual.getPk().getColuna().equalsIgnoreCase(tabelaAntiga.getPk().getColuna())) {
                if (tabelaAtual.getPk().getNome().equalsIgnoreCase(tabelaAntiga.getPk().getNome())) {
                    Auxiliar aux = new Auxiliar();
                    aux.setResultado("Pk iguais");
                    return aux;
                } else {
                    Auxiliar aux = new Auxiliar();
                    aux.setResultado("Pk nomes diferentes");
                    aux.setTabela(tabelaAtual);
                    return aux;
                }
            } else {
                Auxiliar aux = new Auxiliar();
                aux.setResultado("Pk diferentes");
                aux.setTabela(tabelaAtual);
                return aux;
            }
        } else {
            Auxiliar aux = new Auxiliar();
            aux.setResultado("Pk não existe");
            aux.setTabela(tabelaAtual);
            return aux;
        }
    }

    public Auxiliar comparaFk(Tabela tabelaAtual, Tabela tabelaAntiga) {
        List<ForeignKey> lista = new ArrayList<ForeignKey>();
        Auxiliar aux = new Auxiliar();
        for (ForeignKey fkAtual : tabelaAtual.getListaFk()) {
            if (tabelaAntiga.getListaFk().contains(fkAtual)) {
                ForeignKey fkAntiga = tabelaAntiga.getListaFk().get(tabelaAntiga.getListaFk().indexOf(fkAtual));
                comparaFkTabela(fkAntiga, fkAtual);
                comparaFkColunaRef(fkAntiga, fkAtual);
                comparaFkUpdate(fkAntiga, fkAtual);
                comparaFkDelete(fkAntiga, fkAtual);
                comparaFkColuna(fkAntiga, fkAtual);
                comparaFkNome(fkAntiga, fkAtual);
                if (!iguais) {
                    lista.add(fkAtual);
                }
            } else {
                lista = tabelaAtual.getListaFk();
            }
        }
        aux.setTabela(tabelaAntiga);
        aux.getTabela().setListaFk(lista);
        if (!lista.isEmpty()) {
            aux.setResultado("Fk não existe");
        } else {
            aux.setResultado("iguais");
        }
        return aux;
    }

    private void comparaFkTabela(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getTabelaReferencia().equalsIgnoreCase(fkAntiga.getTabelaReferencia())) {
            iguais = true;
        }
    }

    private void comparaFkColunaRef(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getColunaReferencia().equalsIgnoreCase(fkAntiga.getColunaReferencia())) {
            iguais = true;
        }
    }

    private void comparaFkColuna(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getNomeColuna().equalsIgnoreCase(fkAntiga.getNomeColuna())) {
            iguais = true;
        }
    }

    private void comparaFkUpdate(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getUpdateRule().equals(fkAntiga.getUpdateRule())) {
            iguais = true;
        }
    }

    private void comparaFkDelete(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getDeleteRule().equals(fkAntiga.getDeleteRule())) {
            iguais = true;
        }
    }

    private void comparaFkNome(ForeignKey fkAntiga, ForeignKey fkNova) {
        if (fkNova.getNome().equalsIgnoreCase(fkAntiga.getNome())) {
            iguais = true;
        }
    }
}
