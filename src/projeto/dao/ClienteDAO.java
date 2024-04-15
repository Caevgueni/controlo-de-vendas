/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Clientes;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
public class ClienteDAO {
     private Connection con; //criamos o variavel con
     
     

    public ClienteDAO() {
        this.con= new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    // cadatrar Cliente
    public void cadastrarCliente(Clientes obj){
        
        
        try{
            // 1 primeiro passo criar o comando sql
        String sql="insert tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         // 2 passo conectar com o banco de dado e organizar o comamndo sql
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(3, obj.getCpf()); 
         stmt.setString(4, obj.getEmail()); 
         stmt.setString(5, obj.getTelefone()); 
         stmt.setString(6, obj.getTelemovel()); 
         stmt.setString(7, obj.getCep()); 
         stmt.setString(8, obj.getEndereco()); 
         stmt.setInt(9, obj.getNumero()); 
         stmt.setString(10, obj.getComplemento());
         stmt.setString(11, obj.getBairro());
         stmt.setString(12, obj.getCidade());
         stmt.setString(13, obj.getUf());
         
         // 3 passo Executar comando sql
         stmt.execute();
         stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "ERRO" +erro);
            
        }
          
           
    }
    // alterar cliente
     public void alterarCliente(){
        
    }
     // excluir ciente
      public void excluirCliente(){
          
        
    }
      
      // metodo Listar todos os clientes 
      public List<Clientes> listaClisentes(){
          try {
              // 1  primeiro passo criar a lista
              List<Clientes> lista= new ArrayList<>();
              
              // 2 criar o sql, organizar e executar
              
              String sql= "select *from tb_clientes";
              
              PreparedStatement stmt = con.prepareStatement(sql);
              
              // quando se usa um liste o resultado da execucao e guardado neste variavel "ResultSet" 
              ResultSet rs = stmt.executeQuery();
              while(rs.next()){ // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo
                  
                  Clientes obj = new Clientes();
                  
                  obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                  obj.setNome(rs.getString("nome"));
                  obj.setRg(rs.getString("rg"));
                  obj.setCpf(rs.getString("cpf"));
                  obj.setEmail(rs.getString("email"));
                  obj.setTelefone(rs.getString("telefone"));
                  obj.setTelemovel(rs.getString("celular"));
                  obj.setCep(rs.getString("cep"));
                  obj.setEndereco(rs.getString("endereco"));
                  obj.setNumero(rs.getInt("numero"));
                  obj.setComplemento(rs.getString("complemento"));
                  obj.setBairro(rs.getString("bairro"));
                  obj.setCidade(rs.getString("cidade"));
                  obj.setUf(rs.getString("uf"));
                  // uma vez montado objetos pricisamos de lhe colocar o mesmo na lista
              }   // fica de seguinte maneira
                   lista.add(obj);
              
          } catch (Exception e) {
          }
      }
    
}
