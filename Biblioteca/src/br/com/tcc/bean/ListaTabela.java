package br.com.tcc.bean;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan
 */
public class ListaTabela {

    private static Connection conexao;

    public ListaTabela(Connection conexao) {
        this.conexao = conexao;
    }

    public List<String> listaTabela() {
        List<String> lista = new ArrayList<>();
        try {
            DatabaseMetaData dmd = conexao.getMetaData();
            ResultSet rs = dmd.getTables(null, null, null, null);
            while (rs.next()) {
                lista.add(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
