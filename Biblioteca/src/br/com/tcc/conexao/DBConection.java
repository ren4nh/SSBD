package br.com.tcc.conexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Renan
 */
public class DBConection {

    private static Connection conexao;

    public static Connection getPostgres(String sv, String porta, String base, String user, String senha) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection("jdbc:postgresql://"+ sv + ":" + porta + "/" + base , user , senha);
        return conexao;
    }
}
