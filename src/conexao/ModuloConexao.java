package conexao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ModuloConexao {

    public static Connection conector() {
        Connection conexao = null;

//        String url = "jdbc:mysql://mysql857.umbler.com:41890/teste-esp";
//        String driver = "com.mysql.jdbc.Driver";
//        String user = "jonas.vargaski";
//        String password = "jonas123";

 String url = "jdbc:mysql://localhost:3306/teste-esp";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
            return null;
        } finally {

        }

        return conexao;
    }

}
