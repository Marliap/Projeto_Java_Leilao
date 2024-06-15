/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = new conectaDAO().connectDB();

            if (conn != null) {
                String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
                prep = conn.prepareStatement(sql);

                prep.setString(1, produto.getNome());
                prep.setInt(2, produto.getValor());
                prep.setString(3, produto.getStatus());

                prep.executeUpdate();
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto: " + e.getMessage());
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + ex.getMessage());
            }
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
