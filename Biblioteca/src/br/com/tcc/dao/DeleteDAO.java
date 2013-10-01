package br.com.tcc.dao;

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
        String sql = String.format("drop table "
                + "%s"
                + "cascade", tabela.getNome());
        PreparedStatement pst = conexao.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
    }
}
