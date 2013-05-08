package br.com.tcc.conexao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Renan
 */

public class Conexao {
    
    private static Connection conexao;
    private static Properties config = new Properties();
    private static String arquivo = "conexao.properties";
    
    
    public static Connection getPostgres() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        config.load(new FileInputStream(arquivo));
        conexao = DriverManager.getConnection("jdbc:postgresql://" + config.getProperty("url"),config.getProperty("user"), config.getProperty("senha"));
        return conexao;
    }
    
}
