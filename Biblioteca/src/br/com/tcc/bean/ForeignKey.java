package br.com.tcc.bean;

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
}
