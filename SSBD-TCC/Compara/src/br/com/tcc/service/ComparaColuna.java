package br.com.tcc.service;

import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.Tabela;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author renan
 */
public class ComparaColuna {

    private Tabela tabelaAntiga;
    private Tabela tabelaAtual;
    private String baseAntiga;
    private String baseAtual;
    StringBuilder resultado = new StringBuilder();
    StringBuilder diferente = new StringBuilder();
    Map<String, String> mapa = new HashMap<String, String>();
    private boolean addColumn = false;
    private boolean dropColumn = false;
    Coluna coluna = new Coluna();
    Auxiliar aux = new Auxiliar();
    ForeignKey fk = new ForeignKey();

    public ComparaColuna(Tabela tabelaAntiga, Tabela tabelaAtual, String baseAntiga, String baseAtual) {
        this.tabelaAntiga = tabelaAntiga;
        this.tabelaAtual = tabelaAtual;
        this.baseAntiga = baseAntiga;
        this.baseAtual = baseAtual;
    }

    public Auxiliar compara() {
        Tabela tabelaAux = new Tabela();
        for (Coluna colunaAtual : tabelaAtual.getListaColuna()) {
            addColumn = false;
            dropColumn = false;
            coluna = new Coluna();
            comparaTipo(colunaAtual);
            comparaCasas(colunaAtual);
            comparaNulo(colunaAtual);
            comparaTamanho(colunaAtual);
            comparaNome(colunaAtual);
            if (addColumn) {
                coluna.setAcao("addColumn");
                tabelaAux.getListaColuna().add(coluna);
            } else if (dropColumn) {
                coluna = colunaAtual;
                coluna.setAcao("dropColumn");
                tabelaAux.getListaColuna().add(coluna);
            } else {
                coluna.setAcao(null);
            }
        }
        tabelaAux.setNome(tabelaAtual.getNome());
        aux.setTabela(tabelaAux);
        mapa.put("igual", resultado.toString());
        mapa.put("dif", diferente.toString());
        aux.setResultado(mapa);
        return aux;
    }

    private void comparaNome(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getNome().equalsIgnoreCase(colunaAntiga.getNome())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
            } else {
                diferente.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem nomes diferentes.</font><br />");
            }
        } else {
            diferente.append("<font color=GREEN>Deverá ser criada a coluna ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" na tabela ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append("</font><br />");
            if (addColumn) {
                coluna = colunaAtual;
            } else {
                dropColumn = true;
            }
        }
    }

    private void comparaTipo(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getTipo().equalsIgnoreCase(colunaAntiga.getTipo())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo tipo.</font><br />");
            } else {
                diferente.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tipos diferentes.</font><br />");
                dropColumn = true;
            }
        } else {
            addColumn = true;
        }
    }

    private void comparaTamanho(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getTamanho().equalsIgnoreCase(colunaAntiga.getTamanho())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo tamanho.</font><br />");
            } else {
                diferente.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tamanho diferentes.</font><br />");
                dropColumn = true;
            }
        } else {
            addColumn = true;
        }
    }

    private void comparaNulo(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getNulo().equalsIgnoreCase(colunaAntiga.getNulo())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo tamanho.</font><br />");
            } else {
                diferente.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tamanho diferentes.</font><br />");
                dropColumn = true;
            }
        } else {
            addColumn = true;
        }
    }

    private void comparaCasas(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getCasas().equalsIgnoreCase(colunaAntiga.getCasas())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem as mesmas casas decimais.</font><br />");
            } else {
                diferente.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem casas decimais diferentes.</font><br />");
                dropColumn = true;
            }
        } else {
            addColumn = true;
        }
    }
}
