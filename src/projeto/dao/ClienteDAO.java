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
public class ClienteDAO {
     private Connection con; //criamos o variavel con
     
     

    public ClienteDAO() {
        this.con= new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    // cadatrar Cliente
    public void cadastrarCliente(Clientes obj){
        
        // primeiro passo criar o comando sql
        try{
        String sql="insert td_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         //conectar com o banco de dado e organizar o comamndo sql
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(3, obj.getCpf()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(4, obj.getEmail()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(5, obj.getTelefone()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(6, obj.getTelemovel()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(7, obj.getCep()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(8, obj.getEndereco()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setInt(9, obj.getNumero()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(10, obj.getComplemento()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(11, obj.getBairro());// isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(12, obj.getCidade());// isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         stmt.setString(13, obj.getUf());// isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
         
         // Executar comando sql
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
    
}
