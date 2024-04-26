
package projeto.dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Clientes;
import projeto.model.Produtos;
import projeto.model.Vendas;


public class VendasDAO {
    
    
    
    private final Connection con; //criamos o variavel con

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    
    
           // metodo cadastrar vendas
         public void cadastrarVenda(Vendas obj) {

        try {

            String sql = "insert into tb_vendas (cliente_id,data_venda,total_venda, observacoes ) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3,obj.getTotal_veda());
            stmt.setString(4,obj.getObs());
       
            

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Venda registada  com sucesso");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
         
         // metodo retorna ultima venda
         
         public int retonaultimaVenda(){
             
             try {
                 int idvenda = 0;
                 String sql= "select max(id) id from tb_vendas";
                 PreparedStatement ps = con.prepareStatement(sql);
                 Resultset rs = ps.executeQuery();
                 
                 
             } catch (Exception e) {
             }
         }
    
    
    
}
