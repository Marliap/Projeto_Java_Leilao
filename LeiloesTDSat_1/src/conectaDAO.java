
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB() {
        Connection conn = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/leiloestdsat?useSSL=false";
            String user = "root";
            String password = "180203";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não encontrado.");
            JOptionPane.showMessageDialog(null, "Erro: Driver MySQL não encontrado.");
        } catch (SQLException erro) {
            System.out.println(erro.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }

        return conn;
    }
    
}
