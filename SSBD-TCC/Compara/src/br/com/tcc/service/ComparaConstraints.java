package br.com.tcc.service;

import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.PrimaryKey;
import br.com.tcc.bean.Tabela;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class ComparaConstraints {

    private boolean iguais = false;

//    public Auxiliar comparaPk(Tabela tabelaAtual, Tabela tabelaAntiga) {
//        if (!tabelaAntiga.getPk().isEmpty() && !tabelaAtual.getPk().isEmpty()) {
//            for (Object object : tabe) {
//                
//            }
//            if (tabelaAtual.getPk().getColuna().equalsIgnoreCase(tabelaAntiga.getPk().getColuna())) {
//                if (tabelaAtual.getPk().getNome().equalsIgnoreCase(tabelaAntiga.getPk().getNome())) {
//                    Auxiliar aux = new Auxiliar();
//                    aux.setResultado("<font color=BLACK>Primary Keys iguais nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
//                    return aux;
//                } else {
//                    Auxiliar aux = new Auxiliar();
//                    aux.setResultado("<font color=GREEN>Primary Keys possuem nomes diferentes nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
//                    aux.setTabela(tabelaAtual);
//                    return aux;
//                }
//            } else {
//                Auxiliar aux = new Auxiliar();
//                aux.setResultado("<font color=GREEN>Primary Keys são diferentes nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
//                aux.setTabela(tabelaAtual);
//                return aux;
//            }
//        } else {
//            Auxiliar aux = new Auxiliar();
//            aux.setResultado("<font color=GREEN>Primary Key não existe na tabela " + tabelaAntiga.getNome() + "</font><br />");
//            aux.setTabela(tabelaAtual);
//            return aux;
//        }
//    }

    public Auxiliar comparaPk(Tabela tabelaAtual, Tabela tabelaAntiga) {
        List<PrimaryKey> lista = new ArrayList<PrimaryKey>();
        Auxiliar aux = new Auxiliar();
        for (PrimaryKey fkAtual : tabelaAtual.getPk()) {
            if (tabelaAntiga.getPk().contains(fkAtual)) {
                PrimaryKey fkAntiga = tabelaAntiga.getPk().get(tabelaAntiga.getPk().indexOf(fkAtual));
                comparaPkColuna(fkAntiga, fkAtual);
                comparaPkNome(fkAntiga, fkAtual);
                if (!iguais) {
                    lista.add(fkAtual);
                }
            } else {
                lista = tabelaAtual.getPk();
            }
        }
        aux.setTabela(tabelaAntiga);
        aux.getTabela().setPk(lista);
        if (!lista.isEmpty()) {
            aux.setResultado("<font color=GREEN>Primary Keys diferentes nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
        } else {
            aux.setResultado("<font color=BLACK>Primary Keys Keys iguais nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
        }
        return aux;
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
            aux.setResultado("<font color=GREEN>Foreign Keys diferentes nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
        } else {
            aux.setResultado("<font color=BLACK>Foreign Keys Keys iguais nas tabelas " + tabelaAtual.getNome() + " e " + tabelaAntiga.getNome() + "</font><br />");
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
    
    private void comparaPkColuna(PrimaryKey fkAntiga, PrimaryKey fkNova) {
        if (fkNova.getColuna().equalsIgnoreCase(fkAntiga.getColuna())) {
            iguais = true;
        }
    }
    
    private void comparaPkNome(PrimaryKey fkAntiga, PrimaryKey fkNova) {
        if (fkNova.getNome().equalsIgnoreCase(fkAntiga.getNome())) {
            iguais = true;
        }
    }
}
