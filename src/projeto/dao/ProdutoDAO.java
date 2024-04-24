
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet; 


import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Fornecedores;


import projeto.model.Produtos;


public class ProdutoDAO {

    private final Connection con; //criamos o variavel con

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }

    // metodo cadastrar produto
    public void cadastrar(Produtos obj) {

        try {

            String sql = "insert into tb_produtos (descricao, preco,qtd_estoque, for_id) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            // neste caso o java vai pegar a informacao que veio 4 do objeto gornecedor, dando um getId para pegar o id desse fronecedor 
            stmt.setInt(4, obj.getFornecedor().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado cuma sucesso");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
   // listar produtos
    public  List<Produtos>  listarProdutos(){
        
        try {
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.descricao, p.id, p.preco, p.qtd_estoque, f.nome from  tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) ";
            
           PreparedStatement stmt = con.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
                       while (rs.next()) { // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo

                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
                lista.add(obj);
                        
                        
                        
            } return lista;

            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null,"erro"+ erro);
            
            return null;
            
        }
        
    } 
    
 
     // metodo Alterar produto
      public void alterar(Produtos obj) {

        try {

            String sql = "update tb_produtos set descricao=?, preco=?,qtd_estoque=?, for_id=? where id=? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            // neste caso o java vai pegar a informacao que veio 4 do objeto gornecedor, dando um getId para pegar o id desse fronecedor 
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setInt(5, obj.getId());
            

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso cuma sucesso");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "erro: " + erro);

        }

    }
      // Metodo excluir
      public void ecluir(Produtos obj){
          
          try{
           String sql ="delete from td_produtos where id=?"; 
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setInt(1, obj.getId());
          stmt.execute();
          stmt.close();
          JOptionPane.showMessageDialog(null," ProdutoAlterados  com sucesso" );
          } catch(Exception erro){
              JOptionPane.showMessageDialog(null,"Erro: " +erro);
          }
          
      }
    
}
