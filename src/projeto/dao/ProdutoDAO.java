/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Produtos;

/**
 *
 * @author itais
 */
public class ProdutoDAO {
         
   private Connection con; //criamos o variavel con

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    
    // metodo cadastrar produto
    public void cadastrar(Produtos obj){
   
        try {
    
    String sql ="intert into tb_produtos (descricao preco,qtd_estoque, for_id) values (?,?,?,?)";
    
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, obj.getDescricao());
         stmt.setDouble(2, obj.getPreco());
         stmt.setInt(3, obj.getQtd_estoque());
         stmt.ser
         
        }
        catch (Exception e){
            
        }
         
         
     }
}
