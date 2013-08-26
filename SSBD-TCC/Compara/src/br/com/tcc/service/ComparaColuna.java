package br.com.tcc.service;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Tabela;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public class ComparaColuna implements Compara {

    private List<Tabela> listaAntiga = new ArrayList<Tabela>();
    private List<Tabela> listaAtual = new ArrayList<Tabela>();

    public ComparaColuna(Conexao baseAntiga, Conexao baseAtual) {
        listaAntiga = baseAntiga.getListaTabelas();
        listaAtual = baseAtual.getListaTabelas();
    }

    @Override
    public String comparaNome(Conexao baseAntiga, Conexao baseAtual) {
        StringBuilder resultado = new StringBuilder();
//        resultado.append("<html>");
        for (Tabela tabelaAtual : listaAtual) {
            for (Coluna colunaAtual : tabelaAtual.getListaColuna()) {
                Tabela tabelaAntiga = listaAntiga.get(listaAntiga.indexOf(tabelaAtual));
                if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
                    resultado.append("<font color=BLACK>As colunas ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga.getNome()).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
                } else {
                    resultado.append("<font color=GREEN>As colunas ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga.getNome()).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem nomes diferentes.</font><br />");
                }
            }

        }
        return resultado.toString();
    }
}
