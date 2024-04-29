
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet; 
import java.sql.SQLException;


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
      public void alterarProduto(Produtos obj) {

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
      public void excluirProduto(Produtos obj){
          
          try{
           String sql ="delete from tb_produtos where id=? "; 
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setInt(1, obj.getId());
          stmt.execute();
          stmt.close();
          JOptionPane.showMessageDialog(null," ProdutoAlterados  com sucesso" );
          } catch(Exception erro){
              JOptionPane.showMessageDialog(null,"Erro: " +erro);
          }
          
      }
      
      
      // listar produto por nome
      public  List<Produtos>  listarProdutosPorNome(String nome){
        
        try {
            List<Produtos> lista = new ArrayList<>();
            
            String sql = "select p.descricao, p.id, p.preco, p.qtd_estoque, f.nome from  tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ? ";
            
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, nome);
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
    // buscar produto por nome
         //public  Produtos buscarProdutosPorNome(String nome){
        public Produtos consultaPorNome(String nome){
        try {
           
            String sql = "select p.descricao, p.id, p.preco, p.qtd_estoque, f.nome from  tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao= ? ";
            
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, nome);
           ResultSet rs = stmt.executeQuery();
           Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
           
            while (rs.next()) { // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo

                

                obj.setId(rs.getInt("p.id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
               
                f.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(f);
             
            }
            return obj; 

            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null,"erro"+ erro);
            
            return null;
            
        }
        
      } 
        
        // buscar produto por codigo de barra
         //public  Produtos buscarProdutosPorNome(String nome){
        public Produtos consultaPorCosdigoBarra(int id){
        try {
           
            String sql = "select * from  tb_produtos  where id= ? ";
            
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, id);
           ResultSet rs = stmt.executeQuery();
           Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
           
                if (rs.next()) { // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo

                

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
               
              
             
            }
            return obj; 

            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null,"erro"+ erro);
            
            return null;
            
        }
        
      }
   //metodo que baixa o estoque
  public void baixaEstoque(int id, int qtd_nova){
      try {
          String sql = "updata td_produtos ser qtd_estoque =? where id=? ";
          // 2 passo conectar com o banco de dados e organizar o comando sql
          PreparedStatement stmt =con.prepareStatement(sql);
          stmt.setInt(1, qtd_nova);
          stmt.setInt(2, id);
          
          
          stmt.execute();
          stmt.close();
          
                 
      } catch (Exception erro) {
          JOptionPane.showMessageDialog(null," erro" + erro);
      }
  }
  
  // metodo que retorna o estoque actual
  public int retornaEstoqueActual(int id){
      try {
          int qtd_estoque =0;
          String sql= "SELECT qtd_stoque from td_produtos where id=?";
          PreparedStatement stmt =con.prepareStatement(sql);
          stmt.setInt(1, id);
          
          ResultSet rs = stmt.executeQuery();
          if(rs.next()){
            
              qtd_estoque=(rs.getInt("qtd_estoque"));
          }
          return qtd_estoque;
                  
      } catch (SQLException e) {
          throw new RuntimeException(e);
          
      }
  }
        
}
    

