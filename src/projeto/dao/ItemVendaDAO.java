
package projeto.dao;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.ResultSet; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.IntemVenda;
import projeto.model.Produtos;
import projeto.model.Vendas;


public class ItemVendaDAO {
    
    
    private final Connection con; //criamos o variavel con

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    // cadastrar Itmvendas
    
      // metodo cadastrar vendas
         public void cadastrarItem(IntemVenda  obj) {

        try {

            String sql = "insert into tb_itensvendas (venda_id,produto_id,qtd,subtotal) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3,obj.getQtd());
            stmt.setDouble(4,obj.getSubtotal());
       
            

            stmt.execute();
            stmt.close();

           

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
         
         // metodo que liste intens de uma venda por id
    
         public List<IntemVenda> listarItensPorvenda(int venda_id){
             List<IntemVenda> lista= new ArrayList<>();
             try {
                 String sql = "select  p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                         + " inner join tb_produtos as p on(i.produto_id=p.id) where i.venda_id=?";
                 
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setInt(1, venda_id);
                 ResultSet  rs = stmt.executeQuery();
                 while(rs.next()) {
                     IntemVenda item = new IntemVenda();
                     Produtos prod = new Produtos();
                     
                     prod.setDescricao(rs.getString("p.descricao"));   
                     item.setQtd(rs.getInt("i.qtd"));
                     prod.setPreco(rs.getDouble("p.preco"));   
                     item.setSubtotal(rs.getDouble("i.subtotal"));
                     
                     // vinculamos o produdo na liste de item
                     item.setProduto(prod);
                     
                     lista.add(item);
  
                 }
                 return lista;
                 
             } catch (SQLException e) {
                                      throw new RuntimeException(e);

             }
             
         }
}
