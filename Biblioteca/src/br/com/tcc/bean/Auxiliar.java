package br.com.tcc.bean;

import java.util.Map;

/**
 *
 * @author renan
 */
public class Auxiliar {

    private Tabela tabela;
    private Map<String, String> resultado;
    private String acao;

    public Auxiliar() {
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public Map<String, String> getResultado() {
        return resultado;
    }

    public void setResultado(Map<String, String> resultado) {
        this.resultado = resultado;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }
}
