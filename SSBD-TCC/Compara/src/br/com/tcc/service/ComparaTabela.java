package br.com.tcc.service;

import br.com.tcc.bean.Conexao;
import br.com.tcc.bean.Tabela;

/**
 *
 * @author Renan
 */
public class ComparaTabela implements Compara {

    @Override
    public String comparaNome(Conexao baseAntiga, Conexao baseAtual) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<html>");
        for (Tabela tabelaAtual : baseAtual.getListaTabelas()) {
            if (baseAntiga.getListaTabelas().contains(tabelaAtual)) {
                resultado.append("<font color=BLACK>As tabelas ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(" e ").append(baseAntiga.getNome()).append(".").append(baseAntiga.getListaTabelas().get(baseAntiga.getListaTabelas().indexOf(tabelaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
            } else {
                resultado.append("<font color=GREEN>Deverá ser criada a tabela ").append(tabelaAtual.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />");
            }
        }
        for (Tabela tabelaAntiga : baseAntiga.getListaTabelas()) {
            if (!baseAtual.getListaTabelas().contains(tabelaAntiga)) {
               resultado.append("<font color=RED>Deverá ser deletada a tabela ").append(tabelaAntiga.getNome()).append(" na base de dados ").append(baseAntiga.getNome()).append("</font><br />"); 
            }
        }
//        resultado.append("</html>");
        return resultado.toString();
    }
}
