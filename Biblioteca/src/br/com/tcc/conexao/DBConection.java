package br.com.tcc.conexao;

import java.io.FileNotFoundException;
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

    public static Connection getPostgres() throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/APHERP" , "apherp" , "711585");
        return conexao;
    }
}
