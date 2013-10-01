package br.com.tcc.bean;

import java.util.Objects;

/**
 *
 * @author renan
 */
public class ForeignKey {

    private String nome;
    private String nomeColuna;
    private String tabelaReferencia;
    private String colunaReferencia;
    private RuleType updateRule;
    private RuleType deleteRule;

    public ForeignKey() {
    }

    public enum RuleType {

        CASCADE, RESTRICT, NULL, NOACTION, DEFAULT
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTabelaReferencia() {
        return tabelaReferencia;
    }

    public void setTabelaReferencia(String tabelaReferencia) {
        this.tabelaReferencia = tabelaReferencia;
    }

    public String getColunaReferencia() {
        return colunaReferencia;
    }

    public void setColunaReferencia(String colunaReferencia) {
        this.colunaReferencia = colunaReferencia;
    }

    public RuleType getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(RuleType updateRule) {
        this.updateRule = updateRule;
    }

    public RuleType getDeleteRule() {
        return deleteRule;
    }

    public void setDeleteRule(RuleType deleteRule) {
        this.deleteRule = deleteRule;
    }

    public String getNomeColuna() {
        return nomeColuna;
    }

    public void setNomeColuna(String nomeColuna) {
        this.nomeColuna = nomeColuna;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ForeignKey other = (ForeignKey) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
}
