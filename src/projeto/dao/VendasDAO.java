
package projeto.dao;


import com.sun.source.tree.TryTree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

           

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
         
         // metodo retorna ultima venda
         
         public int retonaultimaVenda(){
             
             try {
                 int idvenda = 0;
                 String sql= "select max(id) id from tb_vendas";
                 
                  PreparedStatement stmt = con.prepareStatement(sql);
                  ResultSet rs = stmt.executeQuery();
                  
                  if(rs.next()){
                      Vendas p= new Vendas();
                      p.setId(rs.getInt("id"));
                      idvenda=p.getId();
                  }
                  return idvenda;
                 
                 
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         }
         
         
         //Filtatrar as vendas por datas
         public List<Vendas> listarVendaporPeriodo(LocalDate data_inicio, LocalDate data_fim) {
             
             try {
               //  1 passo crar lista
                 List<Vendas> lista= new ArrayList<>();
                 
                 
                 String sql= "select v.id, v.data_venda, c.nome, v.totalvenda, v.observacaoes from tb_vendas as v"
                         + " inner join td_clientes as c on(v.clientes_id=c.id) where v.data_venda BETWEEN? AND?";
                 
                 PreparedStatement stmt= con.prepareStatement(sql);
                 
                 // informamos de onde vai vir esses dados
                 stmt.setString(1, data_inicio.toString());
                 stmt.setString(1, data_fim.toString()); // o .toString() é para coverta as data para  
                 
                 
                 ResultSet rs= stmt.executeQuery();
                 while (rs.next()){
                     
                     //criamos os dois objetos, porque como as tabelas estao relacionados vamos precisar do dados dad duas tabela 
                     Vendas obj= new Vendas();
                     Clientes c= new Clientes();
                     obj.setId(rs.getInt("v.id"));
                     obj.setData_venda(rs.getString("v.data_venda"));
                     c.setNome(rs.getString("c.nome"));
                     obj.setTotal_veda(rs.getDouble("v.total_venda"));
                     obj.setObs(rs.getString("v.observacoes"));
                     
                     // agora vamos colocar "c.setNome(rs.getString("c.nome"));" dentra de lista 
                    obj.setCliente(c);
                    
                    // adicioamos a lista
                    lista.add(obj);
                 } return lista;
                 
             } catch (SQLException erro) {
                 throw  new RuntimeException(erro);
             }
             
         }
                
    
    
    
}
