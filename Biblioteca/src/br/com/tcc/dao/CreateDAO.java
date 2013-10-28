package br.com.tcc.dao;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author renan
 */
public class CreateDAO {

    private static Connection conexao;

    public CreateDAO(Connection conexao) {
        CreateDAO.conexao = conexao;
    }

    public void create(Tabela t) throws SQLException {
        int contador = 1;
        String tamanho = "";
        String casas = "";
        StringBuilder sql = new StringBuilder();
        if (t != null) {
            sql.append("create table ").append(t.getNome()).append(" ( ");
            for (Coluna coluna : t.getListaColuna()) {
                tamanho = "";
                casas = "";
                if (t.getListaColuna().size() > contador) {
                    if (!coluna.getCasas().equalsIgnoreCase("0")) {
                        casas = "," + coluna.getCasas();
                    }
                    if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                        tamanho = " (" + coluna.getTamanho() + casas + ") ";
                    }
                    sql.append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? "not null" : "").append(",");
                    contador++;
                } else {
                    if (!coluna.getCasas().equalsIgnoreCase("0")) {
                        casas = "," + coluna.getCasas();
                    }
                    if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                        tamanho = " (" + coluna.getTamanho() + casas + ") ";
                    }
                    sql.append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? "not null" : "").append(" ");
                }
            }
            if (t.getPk() != null) {
                sql.append(", constraint ").append(t.getPk().getNome()).append(" primary key ").append("(").append(t.getPk().getColuna()).append(")");
            }
            for (ForeignKey foreignKey : t.getListaFk()) {
                sql.append(", constraint ").append(foreignKey.getNome()).append(" foreign key ").append("(").append(foreignKey.getNomeColuna()).append(")").append(" references ").append(foreignKey.getTabelaReferencia()).append(" (").append(foreignKey.getColunaReferencia()).append(")").append("match simple on update ").append(foreignKey.getUpdateRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : foreignKey.getUpdateRule().toString()).append(" on delete ").append(foreignKey.getDeleteRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : foreignKey.getDeleteRule().toString());
            }
            sql.append(")");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
            pst.executeUpdate();
            pst.close();
        }
    }

    public String createScript(Tabela t) throws SQLException {
        int contador = 1;
        String tamanho = "";
        String casas = "";
        StringBuilder sql = new StringBuilder();
        if (t != null) {
            sql.append("create table ").append(t.getNome()).append(" ( ");
            for (Coluna coluna : t.getListaColuna()) {
                tamanho = "";
                casas = "";
                if (t.getListaColuna().size() > contador) {
                    if (!coluna.getCasas().equalsIgnoreCase("0")) {
                        casas = "," + coluna.getCasas();
                    }
                    if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                        tamanho = " (" + coluna.getTamanho() + casas + ") ";
                    }
                    sql.append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? "not null" : "").append(",");
                    contador++;
                } else {
                    if (!coluna.getCasas().equalsIgnoreCase("0")) {
                        casas = "," + coluna.getCasas();
                    }
                    if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                        tamanho = " (" + coluna.getTamanho() + casas + ") ";
                    }
                    sql.append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? "not null" : "").append(" ");
                }
            }
            if (t.getPk() != null) {
                sql.append(", constraint ").append(t.getPk().getNome()).append(" primary key ").append("(").append(t.getPk().getColuna()).append(")");
            }
            for (ForeignKey foreignKey : t.getListaFk()) {
                sql.append(", constraint ").append(foreignKey.getNome()).append(" foreign key ").append("(").append(foreignKey.getNomeColuna()).append(")").append(" references ").append(foreignKey.getTabelaReferencia()).append(" (").append(foreignKey.getColunaReferencia()).append(")").append("match simple on update ").append(foreignKey.getUpdateRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : foreignKey.getUpdateRule().toString()).append(" on delete ").append(foreignKey.getDeleteRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : foreignKey.getDeleteRule().toString());
            }
            sql.append(")");
        }
        return sql.toString();
    }
}
