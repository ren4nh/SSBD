package br.com.tcc.service;

import br.com.tcc.bean.Auxiliar;
import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.Tabela;

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
    private boolean addColumn = false;
    private boolean alterColumn = false;
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
            coluna = new Coluna();
            comparaTipo(colunaAtual);
            comparaCasas(colunaAtual);
            comparaNulo(colunaAtual);
            comparaTamanho(colunaAtual);
            comparaNome(colunaAtual);
            if (addColumn) {
                coluna.setAcao("addColumn");
                tabelaAux.getListaColuna().add(coluna);
            } else if (alterColumn) {
                coluna.setAcao("alterColumn");
                coluna.setNome(colunaAtual.getNome());
                tabelaAux.getListaColuna().add(coluna);
            } else {
                coluna.setAcao(null);
            }
        }
        tabelaAux.setNome(tabelaAtual.getNome());
        aux.setTabela(tabelaAux);
        aux.setResultado(resultado.toString());
        return aux;
    }

    private void comparaNome(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo nome.</font><br />");
        } else {
            resultado.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem nomes diferentes.</font><br />");
            if (addColumn) {
                coluna = colunaAtual;
            } else {
                coluna.setNome(colunaAtual.getNome());
                alterColumn = true;
            }
        }
    }

    private void comparaTipo(Coluna colunaAtual) {
        if (tabelaAntiga.getListaColuna().contains(colunaAtual)) {
            Coluna colunaAntiga = tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual));
            if (colunaAtual.getTipo().equalsIgnoreCase(colunaAntiga.getTipo())) {
                resultado.append("<font color=BLACK>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(tabelaAntiga.getListaColuna().get(tabelaAntiga.getListaColuna().indexOf(colunaAtual)).getNome()).append(" possuem o mesmo tipo.</font><br />");
            } else {
                resultado.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tipos diferentes.</font><br />");
                coluna.setTipo(colunaAtual.getTipo());
                alterColumn = true;
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
                resultado.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tamanho diferentes.</font><br />");
                coluna.setTamanho(colunaAtual.getTamanho());
                alterColumn = true;
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
                resultado.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem tamanho diferentes.</font><br />");
                coluna.setNulo(colunaAtual.getNulo());
                alterColumn = true;
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
                resultado.append("<font color=GREEN>As colunas ").append(baseAtual).append(".").append(tabelaAtual.getNome()).append(".").append(colunaAtual.getNome()).append(" e ").append(baseAntiga).append(".").append(tabelaAntiga.getNome()).append(".").append(" possuem casas decimais diferentes.</font><br />");
                coluna.setCasas(colunaAtual.getCasas());
                alterColumn = true;
            }
        } else {
            addColumn = true;
        }
    }
}
