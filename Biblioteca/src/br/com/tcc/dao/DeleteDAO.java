package br.com.tcc.dao;

import br.com.tcc.bean.Coluna;
import br.com.tcc.bean.Delete;
import br.com.tcc.bean.Tabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author renan
 */
public class DeleteDAO {

    private static Connection conexao;

    public DeleteDAO(Connection conexao) {
        DeleteDAO.conexao = conexao;
    }

    public void deletar(Tabela tabela) throws SQLException {
        StringBuilder sql = new StringBuilder();
        int contador = 0;
        if (tabela.getListaColuna().isEmpty()) {
            sql.append("drop table ").append(tabela.getNome());
        } else {
            sql.append("alter table ").append(tabela.getNome());
            for (Coluna coluna : tabela.getListaColuna()) {
                if (contador > 1) {
                    sql.append(" drop column ").append(coluna.getNome()).append(" cascade, ");
                } else {
                    sql.append(" drop column ").append(coluna.getNome());
                }
            }
        }
        sql.append(" cascade");
        PreparedStatement pst = conexao.prepareStatement(sql.toString());
        pst.executeUpdate();
        pst.close();
    }
}
