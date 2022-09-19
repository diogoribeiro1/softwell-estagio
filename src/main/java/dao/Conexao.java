package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String url = "jdbc:postgresql://localhost:5432/softwell_db";
    private String usuario = "postgres";
    private String senha = "postgres";

    public Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
        return conn;
    }
}
