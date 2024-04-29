
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.IntemVenda;
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

            JOptionPane.showMessageDialog(null, "Item registada  com sucesso");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
    
}
