package br.com.tcc.dao;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.ForeignKey;
import br.com.tcc.bean.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class AlterDAO {

    private static Connection conexao;

    public AlterDAO(Connection conexao) {
        AlterDAO.conexao = conexao;
    }

    public void alter(Tabela tabela) throws SQLException {
        int contador = 1;
        StringBuilder sql = new StringBuilder();
        String tamanho = "";
        String casas = "";
        if (tabela != null) {
            sql.append("alter table ").append(tabela.getNome());
            if (!tabela.getListaColuna().isEmpty()) {
                for (Coluna coluna : tabela.getListaColuna()) {
                    tamanho = "";
                    casas = "";
                    if (coluna.getAcao().equalsIgnoreCase("dropColumn")) {
                        try {
                            dropColumn(tabela.getNome(), coluna.getNome());
                        } catch (SQLException e) {
                        }
                        if (coluna.getCasas().equalsIgnoreCase("0")) {
                            casas = "," + coluna.getCasas();
                        }
                        if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                            tamanho = " (" + coluna.getTamanho() + casas + ") ";
                        }
                        if (tabela.getListaColuna().size() > contador) {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(",");
                            contador++;
                        } else {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(" ");
                        }
                    } else {
                        if (coluna.getCasas().equalsIgnoreCase("0")) {
                            casas = "," + coluna.getCasas();
                        }
                        if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                            tamanho = " (" + coluna.getTamanho() + casas + ") ";
                        }
                        if (tabela.getListaColuna().size() > contador) {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(",");
                            contador++;
                        } else {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(" ");
                        }
                    }
                }
                PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst.executeUpdate();
                pst.close();
            }
            addPrimaryKey(tabela);
            for (ForeignKey foreignKey : tabela.getListaFk()) {
                addForeignKey(foreignKey, tabela.getNome());
            }
        }
    }

    public String alterScript(Tabela tabela) throws SQLException {
        int contador = 1;
        StringBuilder sql = new StringBuilder();
        String tamanho = "";
        String casas = "";
        if (tabela != null) {
            if (!tabela.getListaColuna().isEmpty()) {
                sql.append("alter table ").append(tabela.getNome());
                for (Coluna coluna : tabela.getListaColuna()) {
                    tamanho = "";
                    casas = "";
                    if (coluna.getAcao().equalsIgnoreCase("dropColumn")) {
                        try {
                            sql.append(dropColumnScript(tabela.getNome(), coluna.getNome()));
                        } catch (SQLException e) {
                        }
                        if (coluna.getCasas().equalsIgnoreCase("0")) {
                            casas = "," + coluna.getCasas();
                        }
                        if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                            tamanho = " (" + coluna.getTamanho() + casas + ") ";
                        }
                        if (tabela.getListaColuna().size() > contador) {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(",");
                            contador++;
                        } else {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(" ");
                        }
                    } else {
                        if (!coluna.getCasas().equalsIgnoreCase("0")) {
                            casas = "," + coluna.getCasas();
                        }
                        if (!coluna.getTamanho().equalsIgnoreCase("0")) {
                            tamanho = " (" + coluna.getTamanho() + casas + ") ";
                        }
                        if (tabela.getListaColuna().size() > contador) {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(",");
                            contador++;
                        } else {
                            sql.append(" add ").append(coluna.getNome()).append(" ").append(coluna.getTipo()).append(tamanho).append(coluna.getNulo().equalsIgnoreCase("NO") ? " not null" : "").append(" ");
                        }
                    }
                    sql.append("\n");
                }
            }
            sql.append(addPrimaryKeyScript(tabela));
            for (ForeignKey foreignKey : tabela.getListaFk()) {
                sql.append(addForeignKeyScript(foreignKey, tabela.getNome()));
            }
        }
        return sql.toString();
    }

    private void dropColumn(String tabela, String coluna) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("alter table ").append(tabela).append(" drop column ").append(coluna).append(" cascade");
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.executeUpdate();
        pst.close();
    }

    private String dropColumnScript(String tabela, String coluna) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("alter table ").append(tabela).append(" drop column ").append(coluna).append(" cascade");
        sql.append("\n");
        return sql.toString();
    }

    private void dropConstraint(String tabela, String nome) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("alter table ").append(tabela).append(" drop constraint ").append(nome);
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.executeUpdate();
        pst.close();
    }

    private String dropConstraintScript(String tabela, String nome) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("alter table ").append(tabela).append(" drop constraint ").append(nome);
        sql.append("\n");
        return sql.toString();
    }

    private void addPrimaryKey(Tabela t) throws SQLException {
        if (t.getPk() != null) {
            try {
                dropConstraint(t.getNome(), t.getPk().getNome());
            } catch (SQLException e) {
            }
            StringBuilder sql = new StringBuilder();
            sql.append("alter table ").append(t.getNome()).append(" add constraint ").append(t.getPk().getNome()).append(" primary key ").append("(").append(t.getPk().getColuna()).append(")");
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
            pst.executeUpdate();
            pst.close();
        }
    }

    private String addPrimaryKeyScript(Tabela t) throws SQLException {
        StringBuilder sql = new StringBuilder();
        if (t.getPk() != null) {
            try {
                sql.append(dropConstraintScript(t.getNome(), t.getPk().getNome()));
            } catch (SQLException e) {
            }
            sql.append("alter table ").append(t.getNome()).append(" add constraint ").append(t.getPk().getNome()).append(" primary key ").append("(").append(t.getPk().getColuna()).append(")");
            sql.append("\n");
        }
        return sql.toString();
    }

    private void addForeignKey(ForeignKey fk, String tabela) throws SQLException {
        StringBuilder sql = new StringBuilder();
        try {
            dropConstraint(tabela, fk.getNome());
        } catch (SQLException ex) {
        }
        sql.append("alter table ").append(tabela).append(" add constraint ").append(fk.getNome()).append(" foreign key ").append("(").append(fk.getNomeColuna()).append(")").append(" references ").append(fk.getTabelaReferencia()).append(" (").append(fk.getColunaReferencia()).append(")").append("match simple on update ").append(fk.getUpdateRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : fk.getUpdateRule().toString()).append(" on delete ").append(fk.getDeleteRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : fk.getDeleteRule().toString());
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.executeUpdate();
        pst.close();
    }

    private String addForeignKeyScript(ForeignKey fk, String tabela) throws SQLException {
        StringBuilder sql = new StringBuilder();
        try {
            sql.append(dropConstraintScript(tabela, fk.getNome()));
        } catch (SQLException ex) {
        }
        sql.append("alter table ").append(tabela).append(" add constraint ").append(fk.getNome()).append(" foreign key ").append("(").append(fk.getNomeColuna()).append(")").append(" references ").append(fk.getTabelaReferencia()).append(" (").append(fk.getColunaReferencia()).append(")").append("match simple on update ").append(fk.getUpdateRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : fk.getUpdateRule().toString()).append(" on delete ").append(fk.getDeleteRule().toString().equalsIgnoreCase("NOACTION") ? "no action" : fk.getDeleteRule().toString());
        sql.append("\n");
        return sql.toString();
    }
}
