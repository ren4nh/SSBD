package br.com.tcc.view;

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
        for (Tabela tabelaAntiga : baseAntiga.getListaTabelas()) {
            for (Tabela tabelaAtual : baseAtual.getListaTabelas()) {
                if (tabelaAntiga.getNome().equals(tabelaAtual.getNome())) {
                    resultado.append("<font color=GREEN>As tabelas ").append(baseAntiga.getNome()).append(".").append(tabelaAntiga.getNome()).append(" e ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(" possuem o mesmo nome.</font><br />");
                } else {
                    resultado.append("<font color=RED>As tabelas ").append(baseAntiga.getNome()).append(".").append(tabelaAntiga.getNome()).append(" e ").append(baseAtual.getNome()).append(".").append(tabelaAtual.getNome()).append(" possuem nomes diferentes.</font><br />");
                }
            }
        }
        resultado.append("</html>");
        return resultado.toString();
    }
    
}
